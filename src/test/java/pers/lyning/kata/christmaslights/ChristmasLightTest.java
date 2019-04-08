package pers.lyning.kata.christmaslights;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ChristmasLightTest {

    private ChristmasLight christmasLight;

    @Before
    public void setUp() throws Exception {
        this.christmasLight = new ChristmasLight();
    }

    @Test
    public void should_return_9_lights_when_turn_on_00_22() {
        turnOn(Score.create().start(0, 0).end(2, 2));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(9);
    }

    @Test
    public void should_return_5_lights_when_turn_on_00_22_after_turn_off_11_22() {
        turnOn(Score.create().start(0, 0).end(2, 2));
        turnOff(Score.create().start(1, 1).end(2, 2));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(5);
    }

    @Test
    public void should_return_4_lights_when_turn_on_00_22_and_toggle_11_22_then_turn_off_00_22() {
        turnOn(Score.create().start(0, 0).end(2, 2));
        toggle(Score.create().start(1, 1).end(2, 2));
        turnOff(Score.create().start(0, 0).end(2, 2));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(4);
    }

    @Test
    public void should_return_9_lights_when_turn_on_00_22_and_toggle_11_22_then_turn_off_33_44() {
        turnOn(Score.create().start(0, 0).end(2, 2));
        toggle(Score.create().start(1, 1).end(2, 2));
        turnOff(Score.create().start(3, 3).end(4, 4));
        Integer numberOfLights = christmasLight.getLights();
        assertThat(numberOfLights).isEqualTo(9);
    }

    @Test
    public void should_return_17_brightness_when_turn_on_00_22_and_toggle_11_22() {
        turnOn(Score.create().start(0, 0).end(2, 2));
        toggle(Score.create().start(1, 1).end(2, 2));
        Integer brightness = christmasLight.totalBrightness();
        assertThat(brightness).isEqualTo(17);
    }

    @Test
    public void should_return_1000000_brightness_when_turn_on_00_999999() {
        turnOn(Score.create().start(0, 0).end(999, 999));
        Integer brightness = christmasLight.totalBrightness();
        assertThat(brightness).isEqualTo(1000000);
    }

    @Test
    public void should_return_999996_lights_when_after_following_the_instructions() {
        turnOn(Score.create().start(0, 0).end(999, 999));
        toggle(Score.create().start(0, 0).end(999, 0));
        turnOff(Score.create().start(0, 0).end(999, 999));
        turnOn(Score.create().start(0, 1).end(999, 999));
        turnOff(Score.create().start(499, 499).end(500, 500));
        assertThat(christmasLight.getLights()).isEqualTo(999996);
    }

    @Test
    public void should_return_1000996_brightness_when_after_following_the_instructions() {
        turnOn(Score.create().start(0, 0).end(999, 999));
        toggle(Score.create().start(0, 0).end(999, 0));
        turnOff(Score.create().start(0, 0).end(999, 999));
        turnOn(Score.create().start(0, 1).end(999, 999));
        turnOff(Score.create().start(499, 499).end(500, 500));
        assertThat(christmasLight.totalBrightness()).isEqualTo(1000996);
    }

    private void turnOn(Score score) {
        christmasLight.turnOn(score);
    }

    private void turnOff(Score score) {
        christmasLight.turnOff(score);
    }

    private void toggle(Score score) {
        christmasLight.toggle(score);
    }
}
