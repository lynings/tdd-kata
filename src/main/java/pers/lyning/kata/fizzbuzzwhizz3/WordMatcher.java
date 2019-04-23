package pers.lyning.kata.fizzbuzzwhizz3;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class WordMatcher {
    private final SpecialNumber first;
    private final List<SpecialNumber> specialNumbers;

    public WordMatcher(SpecialNumber first, SpecialNumber second, SpecialNumber third) {
        this.first = first;
        this.specialNumbers = Arrays.asList(first, second, third);
    }

    public String match(Number number) {
        if (number.contains(this.first.getNumber())) {
            return first.getWord();
        }

        return specialNumbers
                .stream()
                .map(specialNumber -> getWord(number, specialNumber))
                .filter(word -> !word.isEmpty())
                .reduce(this::mergeWord)
                .orElse(number.value().toString());
    }

    private String getWord(Number number, SpecialNumber specialNumber) {
        return number.isDivisibleBy(specialNumber.getNumber()) ? specialNumber.getWord() : "";
    }

    private String mergeWord(String w1, String w2) {
        return w1.concat(w2);
    }
}
