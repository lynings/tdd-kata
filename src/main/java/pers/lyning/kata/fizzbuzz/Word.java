package pers.lyning.kata.fizzbuzz;

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

    public boolean match(Integer number) {
        Number num = Number.of(number);
        if (num.isDivisibleBy(this.number) || num.isContains(this.number)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
