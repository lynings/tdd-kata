package pers.lyning.kata.christmaslights;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ChristmasLightTest {

    @Test
    public void should_return_9_lights_when_turn_on_00_22() {
        ChristmasLight christmasLight = new ChristmasLight();
        Score score = Score.create().start(0, 0).end(2, 2);
        christmasLight.turnOn(score);
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(9);
    }

    @Test
    public void should_return_5_lights_when_turn_on_00_22_after_turn_off_11_22() {
        ChristmasLight christmasLight = new ChristmasLight();
        christmasLight.turnOn(Score.create().start(0, 0).end(2, 2));
        christmasLight.turnOff(Score.create().start(1, 1).end(2, 2));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(5);
    }

    @Test
    public void should_return_4_lights_when_turn_on_00_22_and_toggle_11_22_then_turn_off_00_22() {
        ChristmasLight christmasLight = new ChristmasLight();
        christmasLight.turnOn(Score.create().start(0, 0).end(2, 2));
        christmasLight.toggle(Score.create().start(1, 1).end(2, 2));
        christmasLight.turnOff(Score.create().start(0, 0).end(2, 2));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(4);
    }

    @Test
    public void should_return_9_lights_when_turn_on_00_22_and_toggle_11_22_then_turn_off_33_44() {
        ChristmasLight christmasLight = new ChristmasLight();
        christmasLight.turnOn(Score.create().start(0, 0).end(2, 2));
        christmasLight.toggle(Score.create().start(1, 1).end(2, 2));
        christmasLight.turnOff(Score.create().start(3, 3).end(4, 4));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(9);
    }

    @Test
    public void should_return_13_brightness_when_turn_on_00_22_and_toggle_11_22() {
        ChristmasLight christmasLight = new ChristmasLight();
        christmasLight.turnOn(Score.create().start(0, 0).end(2, 2));
        christmasLight.toggle(Score.create().start(1, 1).end(2, 2));
        Integer brightness = christmasLight.totalBrightness();
        assertThat(brightness).isEqualTo(13);
    }
}
