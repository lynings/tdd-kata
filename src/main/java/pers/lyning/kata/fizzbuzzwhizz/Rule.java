package pers.lyning.kata.fizzbuzzwhizz;

/**
 * @author lyning
 */
public class Rule {
    private final UniqueNumbers uniqueNumbers;

    public Rule(UniqueNumbers uniqueNumbers) {
        this.uniqueNumbers = uniqueNumbers;
    }

    public String match(Integer number) {
        if (isContainFirstNumber(number)) {
            return uniqueNumbers.getFirst().getWord();
        }
        return uniqueNumbers
                .getNumberAndWords()
                .stream()
                .filter(item -> isDivisible(number, item.getNumber()))
                .map(item -> item.getWord())
                .reduce((w1, w2) -> w1 + w2)
                .orElse(number.toString());
    }

    private boolean isDivisible(Integer divisor, Integer dividend) {
        return divisor % dividend == 0;
    }

    private boolean isContainFirstNumber(Integer number) {
        if (number.toString().contains(uniqueNumbers.getFirst().getNumber().toString())) {
            return true;
        }
        return false;
    }
}

