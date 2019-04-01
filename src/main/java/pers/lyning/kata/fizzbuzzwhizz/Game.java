package pers.lyning.kata.fizzbuzzwhizz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Game {
    private static final Integer MIN_NUMBER_OF_PLAYERS = 1;
    private final Rule rule;
    private Integer totalPlayers;

    public Game(Integer totalPlayers, UniqueNumbers uniqueNumbers) {
        this.totalPlayers = totalPlayers;
        this.rule = new Rule(uniqueNumbers);
    }

    public List<String> countOff() throws Exception {
        this.validate();

        return this.takeTurns();
    }

    /**
     * 代表按次序一个接一个地周而复始
     *
     * @return
     */
    private List<String> takeTurns() {
        List<String> results = new ArrayList<>(this.totalPlayers);
        for (Integer number = 1; number <= this.totalPlayers; number++) {
            results.add(this.rule.match(number));
        }
        return results;
    }

    private void validate() throws Exception {
        if (this.totalPlayers < MIN_NUMBER_OF_PLAYERS) {
            throw new Exception("游戏至少需要一名玩家！");
        }
    }
}

