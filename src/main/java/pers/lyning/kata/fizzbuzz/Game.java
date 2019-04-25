package pers.lyning.kata.fizzbuzz;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class Game {
    private int players;

    public Game(int players) {
        this.players = players;
    }

    public List<String> play() {
        return IntStream
                .range(1, this.players + 1)
                .boxed()
                .map(Number::new)
                .map(this::matchWord)
                .collect(toList());
    }

    private String matchWord(Number number) {
        if (number.isFizzBuzz()) {
            return "FizzBuzz";
        }

        if (number.isFizz() && number.isBuzz()) {
            return "FizzBuzz";
        }

        if (number.isFizz()) {
            return "Fizz";
        }

        if (number.isBuzz()) {
            return "Buzz";
        }
        return number.value().toString();
    }
}
