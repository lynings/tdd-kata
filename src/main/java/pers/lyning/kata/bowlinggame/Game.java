package pers.lyning.kata.bowlinggame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Game {

    private final Integer FRAMES = 10;
    private final Integer PINS = 10;
    private final List<Integer> pins = new ArrayList<>();

    public Integer getScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frameIndex = 1; frameIndex <= this.FRAMES; frameIndex++) {
            if (this.isStrike(rollIndex)) {
                score += (this.PINS + this.strikeBonus(rollIndex));
                rollIndex += 1;
            } else if (this.isSpare(rollIndex)) {
                score += (this.PINS + this.spareBonus(rollIndex));
                rollIndex += 2;
            } else {
                score += (this.pins.get(rollIndex) + this.pins.get(rollIndex + 1));
                rollIndex += 2;
            }
        }
        return score;
    }

    public void roll(Integer pins) {
        this.pins.add(pins);
    }

    private boolean isSpare(Integer rollIndex) {
        return this.PINS.equals(this.pins.get(rollIndex) + this.pins.get(rollIndex + 1));
    }

    private boolean isStrike(Integer rollIndex) {
        return this.PINS.equals(this.pins.get(rollIndex));
    }

    private Integer spareBonus(Integer rollIndex) {
        return this.pins.get(rollIndex + 2);
    }

    private Integer strikeBonus(int rollIndex) {
        return this.pins.get(rollIndex + 1) + this.pins.get(rollIndex + 2);
    }
}
