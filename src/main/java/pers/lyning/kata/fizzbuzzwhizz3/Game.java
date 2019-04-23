package pers.lyning.kata.fizzbuzzwhizz3;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class Game {

    private final WordMatcher wordMatcher;

    public Game(Integer firstNumber, Integer secondNumber, Integer thirdNumber) {
        SpecialNumber first = new SpecialNumber(firstNumber, "Fizz");
        SpecialNumber second = new SpecialNumber(secondNumber, "Buzz");
        SpecialNumber third = new SpecialNumber(thirdNumber, "Whizz");
        this.wordMatcher = new WordMatcher(first, second, third);
    }

    public List<String> countOff(int players) {
        return IntStream
                .range(1, players + 1)
                .boxed()
                .map(Number::new)
                .map(wordMatcher::match)
                .collect(toList());
    }
}
