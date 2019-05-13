package pers.lyning.kata.fizzbuzz;

import java.util.Optional;

/**
 * @author lyning
 */
class Word {
    private final String name;
    private final Integer number;

    private Word(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public static Word buzz() {
        return new Word(5, "Buzz");
    }

    public static Word fizz() {
        return new Word(3, "Fizz");
    }

    public Optional<String> match(Integer number) {
        Number num = Number.of(number);
        if (num.isDivisibleBy(this.number) || num.isContains(this.number)) {
            return Optional.of(this.name);
        }
        return Optional.empty();
    }
}
