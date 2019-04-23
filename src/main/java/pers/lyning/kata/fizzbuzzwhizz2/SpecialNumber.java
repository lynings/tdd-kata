package pers.lyning.kata.fizzbuzzwhizz2;

/**
 * @author lyning
 */
public class SpecialNumber {
    private final Integer number;
    private final String word;

    public SpecialNumber(Integer number, String word) {

        this.number = number;
        this.word = word;
    }

    public Integer getNumber() {
        return number;
    }

    public String getWord() {
        return word;
    }

    public String matchWord(Number number) {
        return number.isDivisibleBy(this.getNumber()) ? this.getWord() : "";
    }
}
