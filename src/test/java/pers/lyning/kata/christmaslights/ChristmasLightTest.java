package pers.lyning.kata.christmaslights;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ChristmasLightTest {

    @Test
    public void should_return_9_when_turn_on_00_22() {
        ChristmasLight christmasLight = new ChristmasLight();
        Score score = Score.create().start(0, 0).end(2, 2);
        christmasLight.turnOn(score);
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(9);
    }

    @Test
    public void should_return_5_when_turn_on_00_22_after_turn_off_11_22() {
        ChristmasLight christmasLight = new ChristmasLight();
        christmasLight.turnOn(Score.create().start(0, 0).end(2, 2));
        christmasLight.turnOff(Score.create().start(1, 1).end(2, 2));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(5);
    }
}
