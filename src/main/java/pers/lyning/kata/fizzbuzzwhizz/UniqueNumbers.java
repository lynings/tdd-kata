package pers.lyning.kata.fizzbuzzwhizz;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lyning
 */
public class UniqueNumbers {
    private static final Integer LIMITED_NUMBER = 3;
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;
    private final NumberAndWord first;
    private final List<NumberAndWord> numberAndWords;
    private final NumberAndWord second;
    private final NumberAndWord third;

    public UniqueNumbers(Integer firstNumber, Integer secondNumber, Integer thirdNumber) throws Exception {
        this.first = new NumberAndWord(firstNumber, "Fizz");
        this.second = new NumberAndWord(secondNumber, "Buzz");
        this.third = new NumberAndWord(thirdNumber, "Whizz");
        this.numberAndWords = Arrays.asList(this.first, this.second, this.third);
        this.validate();
    }

    public NumberAndWord getFirst() {
        return this.first;
    }

    public List<NumberAndWord> getNumberAndWords() {
        return this.numberAndWords;
    }

    public void validate() throws Exception {
        Set<Integer> uniqueNumberSet = this.distinct();

        if (uniqueNumberSet.size() != LIMITED_NUMBER) {
            throw new Exception("请输入三个不同的个位数字！");
        }
        for (Integer uniqueNumber : uniqueNumberSet) {
            if (MIN_NUMBER > uniqueNumber || MAX_NUMBER < uniqueNumber) {
                throw new Exception(String.format("数字不能小于%d或大于%d！", MIN_NUMBER, MAX_NUMBER));
            }
        }
    }

    private Set<Integer> distinct() {
        return this.numberAndWords
                .stream()
                .map(item -> item.getNumber())
                .filter(number -> !Objects.isNull(number))
                .collect(Collectors.toSet());
    }

    class NumberAndWord {

        private final Integer number;
        private final String word;

        public NumberAndWord(Integer number, String word) {
            this.number = number;
            this.word = word;
        }

        public Integer getNumber() {
            return this.number;
        }

        public String getWord() {
            return this.word;
        }
    }
}
