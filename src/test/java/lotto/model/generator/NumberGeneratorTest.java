package lotto.model.generator;

import lotto.model.Lotto;
import lotto.model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    NumberGenerator numberGenerator = new NumberGenerator();

    @DisplayName("로또 숫자를 " + Lotto.SIZE + "개 추출한다")
    @Test
    void searchNumbers() {
        List<Number> number = numberGenerator.peek(Lotto.SIZE);
        assertThat(number).contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }

    public static Number[] ofNumbers(int... numbers) {
        return IntStream.of(numbers)
                .mapToObj(Number::of)
                .toArray(Number[]::new);
    }
}