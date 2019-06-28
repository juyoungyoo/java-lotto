package lotto.model.generator;

import lotto.exception.NumbersIsEmptyException;
import lotto.model.Lotto;
import lotto.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


public class ManualLottoGenerator implements LottoGenerator {

    private List<String> numbers;

    public ManualLottoGenerator(List<String> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new NumbersIsEmptyException();
        }
        this.numbers = numbers;
    }

    @Override
    public List<Lotto> generator() {
        return numbers.stream()
                .map(StringUtils::parseNumbers)
                .map(Lotto::from)
                .collect(Collectors.toList());
    }
}