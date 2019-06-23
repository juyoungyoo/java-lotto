package lotto.model;

import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    @DisplayName("당첨번호를 생성합니다")
    @Test
    void createWinningLotto() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto winningLotto = LottoMachine.getWinningLotto(numbers);

        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto).isEqualTo(ofLotto(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("한개의 로또를 구매한다")
    @Test
    void buyLottoWithMoney() {
        Money money = Money.wons(1000);

        LottoTicket result = LottoMachine.buy(money);

        assertThat(result.getLottos()).hasSize(1);
    }

    @DisplayName("14500원이면 로또를 14개 구매한다")
    @Test
    void buyManyLottoWithMoney() {
        Money money = Money.wons(14500);

        LottoTicket lottoTicket = LottoMachine.buy(money);

        assertThat(lottoTicket.getLottos()).hasSize(14);
    }

    @DisplayName("0원이면 로또를 구매할 수 없다")
    @Test
    void buyLottoWithZeroMoney() {
        Money money = Money.wons(0);

        assertThatExceptionOfType(MinimumAmountException.class)
                .isThrownBy(() -> LottoMachine.buy(money));
    }
}