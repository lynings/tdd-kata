package pers.lyning.kata.bowlinggame;

/**
 * @author lyning
 */
public class Game {
    private Integer score = 0;

    public void roll(Integer pins) {
        score += pins;
    }

    public Integer getScore() {
        return score;
    }
}
