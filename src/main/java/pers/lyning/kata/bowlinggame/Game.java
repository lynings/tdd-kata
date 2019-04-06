package pers.lyning.kata.bowlinggame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Game {

    private final Integer PINS = 10;
    private final Integer FRAMES = 10;
    private List<Integer> pins = new ArrayList<>();

    public void roll(Integer pins) {
        this.pins.add(pins);
    }

    public Integer getScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frameIndex = 1; frameIndex <= FRAMES; frameIndex++) {
            if (frameIndex < FRAMES) {
                if (this.isStrike(rollIndex)) {
                    score += (PINS + this.strikeBonus(rollIndex));
                    rollIndex += 1;
                } else if (this.isSpare(rollIndex)) {
                    score += (PINS + this.spareBonus(rollIndex));
                    rollIndex += 2;
                } else {
                    score += (pins.get(rollIndex) + pins.get(rollIndex + 1));
                    rollIndex += 2;
                }
            } else {
                for (; rollIndex < pins.size(); rollIndex++) {
                    score += pins.get(rollIndex);
                }
            }
        }
        return score;
    }

    private Integer strikeBonus(int rollIndex) {
        return this.pins.get(rollIndex + 1) + this.pins.get(rollIndex + 2);
    }

    private Integer spareBonus(Integer rollIndex) {
        return this.pins.get(rollIndex + 1);
    }

    private boolean isStrike(Integer rollIndex) {
        return PINS.equals(pins.get(rollIndex));
    }

    private boolean isSpare(Integer rollIndex) {
        return PINS.equals(this.pins.get(rollIndex) + this.pins.get(rollIndex + 1));
    }
}
