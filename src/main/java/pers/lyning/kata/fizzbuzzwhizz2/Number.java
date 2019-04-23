package pers.lyning.kata.fizzbuzzwhizz2;

/**
 * @author lyning
 */
public class Number {
    private Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

    public boolean isDivisibleBy(Integer divided) {
        return this.value % divided == 0;
    }

    public boolean contains(Integer number) {
        return this.value.toString().contains(number.toString());
    }
}
