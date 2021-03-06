package pers.lyning.kata.fizzbuzzwhizz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Game {
    private static final Integer MIN_NUMBER_OF_PLAYERS = 1;
    private final UniqueNumbers uniqueNumbers;
    private Integer totalPlayers = 0;

    private Game(Integer firstNumber, Integer secondNumber, Integer thirdNumber) throws Exception {
        this.uniqueNumbers = new UniqueNumbers(firstNumber, secondNumber, thirdNumber);
    }

    public List<String> countOff(Integer totalPlayers) throws Exception {
        this.totalPlayers = totalPlayers;
        this.validate();
        return this.takeTurns();
    }

    public static Game of(Integer firstNumber, Integer secondNumber, Integer thirdNumber) throws Exception {
        return new Game(firstNumber, secondNumber, thirdNumber);
    }

    private boolean isContainFirstNumber(Integer number) {
        return number.toString()
                .contains(this.uniqueNumbers.getFirst()
                        .getNumber()
                        .toString());
    }

    private boolean isDivisible(Integer divisor, Integer dividend) {
        return divisor % dividend == 0;
    }

    private String match(Integer order) {
        if (this.isContainFirstNumber(order)) {
            return this.uniqueNumbers.getFirst()
                    .getWord();
        }
        return this.uniqueNumbers
                .getNumberAndWords()
                .stream()
                .filter(item -> this.isDivisible(order, item.getNumber()))
                .map(item -> item.getWord())
                .reduce((w1, w2) -> w1 + w2)
                .orElse(order.toString());
    }

    /**
     * 代表按次序一个接一个地周而复始
     *
     * @return
     */
    private List<String> takeTurns() {
        List<String> results = new ArrayList<>(this.totalPlayers);
        for (Integer number = 1; number <= this.totalPlayers; number++) {
            results.add(this.match(number));
        }
        return results;
    }

    private void validate() throws Exception {
        if (this.totalPlayers < MIN_NUMBER_OF_PLAYERS) {
            throw new Exception("游戏至少需要一名玩家！");
        }
    }
}

