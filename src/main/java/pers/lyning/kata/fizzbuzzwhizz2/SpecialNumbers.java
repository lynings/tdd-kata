package pers.lyning.kata.fizzbuzzwhizz2;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class SpecialNumbers {
    private final SpecialNumber first;
    private final SpecialNumber second;
    private final SpecialNumber third;

    public SpecialNumbers(Integer firstNumber, Integer secondNumber, Integer thirdNumber) {
        this.first = new SpecialNumber(firstNumber, "Fizz");
        this.second = new SpecialNumber(secondNumber, "Buzz");
        this.third = new SpecialNumber(thirdNumber, "Whizz");
    }

    public SpecialNumber getFirst() {
        return first;
    }

    public SpecialNumber getSecond() {
        return second;
    }

    public SpecialNumber getThird() {
        return third;
    }

    public List<SpecialNumber> toList() {
        return Arrays.asList(this.first, this.second, this.third);
    }
}
