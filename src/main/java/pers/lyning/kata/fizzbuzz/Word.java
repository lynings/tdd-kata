package pers.lyning.kata.fizzbuzz2;

import java.util.Optional;

/**
 * @author lyning
 */
class Word {
    private final Integer number;
    private final String name;

    private Word(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public static Word fizz() {
        return new Word(3, "Fizz");
    }

    public static Word buzz() {
        return new Word(5, "Buzz");
    }

    public Optional<String> match(Integer number) {
        Number num = Number.of(number);
        if (num.isDivisibleBy(this.number) || num.isContains(this.number)) {
            return Optional.of(name);
        }
        return Optional.empty();
    }
}
