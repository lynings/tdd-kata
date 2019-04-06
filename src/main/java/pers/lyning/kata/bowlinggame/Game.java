package pers.lyning.kata.bowlinggame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Game {

    private final Integer PINS = 10;
    private List<Integer> pins = new ArrayList<>();

    public void roll(Integer pins) {
        this.pins.add(pins);
    }

    public Integer getScore() {
        int frame = 1;
        int score = 0;
        for (int number = 0; number < pins.size(); number++) {
            if (frame < 10) {
                if (this.isStrike(pins.get(number))) {
                    score += (pins.get(number) + pins.get(number + 1) + pins.get(number + 2));
                    frame += 1;
                } else {
                    score += pins.get(number);
                }
            } else {
                for (; number < pins.size(); number++) {
                    score += pins.get(number);
                }
            }
        }
        return score;
    }

    private boolean isStrike(Integer pins) {
        return PINS.equals(pins);
    }

    private boolean isSpare(Integer firstPins, Integer secondPins) {
        return PINS.equals(firstPins + secondPins);
    }
}
