package pers.lyning.kata.fizzbuzz;

/**
 * @author lyning
 */
public class Number {
    private Integer value;

    public Number(Integer value) {
        this.value = value;
    }

    public boolean isFizz() {
        return isDivisibleBy(3) || this.contains(3);
    }


    public boolean isBuzz() {
        return isDivisibleBy(5) || this.contains(5);
    }

    public boolean isFizzBuzz() {
        return isDivisibleBy(3) && isDivisibleBy(5)
                || (isFizz() && this.isBuzz());
    }

    public Integer value() {
        return this.value;
    }

    private boolean isDivisibleBy(Integer number) {
        return this.value % number == 0;
    }

    private boolean contains(Integer number) {
        return this.value.toString().contains(number.toString());
    }
}
