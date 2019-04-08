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
}
