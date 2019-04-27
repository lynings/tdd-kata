package pers.lyning.kata.fizzbuzz2;

/**
 * @author lyning
 */
class Number {
    private Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public static Number of(Integer number) {
        return new Number(number);
    }

    public boolean isDivisibleBy(Integer number) {
        return this.value % number == 0;
    }

    public boolean isContains(Integer number) {
        return this.value
                .toString()
                .contains(number.toString());
    }
}
