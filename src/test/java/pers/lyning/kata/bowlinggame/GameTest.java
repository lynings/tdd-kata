package pers.lyning.kata.bowlinggame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void should_return_0_score_when_10_frame_knock_down_0_pins() throws Exception {
        Game game = new Game();
        int frames = 10;
        int timesOfFrame = 2;
        for (int num = 1; num <= frames * timesOfFrame; num++) {
            game.roll(0);
        }
        assertThat(game.getScore()).isEqualTo(0);
    }
}