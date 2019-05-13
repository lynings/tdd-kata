package pers.lyning.kata.fizzbuzz;

/**
 * @author lyning
 */
class Number {
    private final Integer value;

    private Number(Integer value) {
        this.value = value;
    }

    public static Number of(Integer number) {
        return new Number(number);
    }

    public boolean isContains(Integer number) {
        return this.value
                .toString()
                .contains(number.toString());
    }

    public boolean isDivisibleBy(Integer number) {
        return this.value % number == 0;
    }
}
