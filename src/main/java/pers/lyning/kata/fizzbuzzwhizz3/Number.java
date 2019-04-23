package pers.lyning.kata.fizzbuzzwhizz3;

/**
 * @author lyning
 */
public class Number {
    private Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public boolean isDivisibleBy(Integer number) {
        return this.value % number == 0;
    }

    public boolean contains(Integer number) {
        return this.value.toString().contains(number.toString());
    }

    public Integer value() {
        return this.value;
    }
}
