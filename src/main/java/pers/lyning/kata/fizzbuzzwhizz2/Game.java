package pers.lyning.kata.fizzbuzzwhizz2;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class Game {
    private final SpecialNumbers specialNumbers;

    public Game(Integer firstNumber, Integer secondNumber, Integer thirdNumber) {
        specialNumbers = new SpecialNumbers(firstNumber, secondNumber, thirdNumber);
    }

    public List<String> countOff(int players) {
        List<String> results = IntStream
                .range(1, players + 1)
                .boxed()
                .map(Number::new)
                .map(this::turn)
                .collect(toList());
        return results;
    }

    private String turn(Number number) {
        if (number.contains(this.specialNumbers.getFirst().getNumber())) {
            return this.specialNumbers.getFirst().getWord();
        }

        return this.specialNumbers
                .toList()
                .stream()
                .map(specialNumber -> specialNumber.matchWord(number))
                .filter(word -> !word.isEmpty())
                .reduce(this::mergeWord)
                .orElse(number.value().toString());
    }

    private String mergeWord(String word1, String word2) {
        return word1.concat(word2);
    }
}
