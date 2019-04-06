package pers.lyning.kata.bowlinggame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void should_return_0_score_when_10_frames_knock_down_0_pins() throws Exception {
        Game game = new Game();
        int frames = 10;
        int timesOfFrame = 2;
        for (int num = 1; num <= frames * timesOfFrame; num++) {
            game.roll(0);
        }
        assertThat(game.getScore()).isEqualTo(0);
    }

    @Test
    public void should_return_90_score_when_each_frame_knock_down_9_pins() throws Exception {
        Game game = new Game();
        int frames = 10;
        int timesOfFrame = 2;
        for (int num = 1; num <= frames * timesOfFrame; num++) {
            if (num % 2 == 0) {
                game.roll(5);
            } else {
                game.roll(4);
            }
        }
        assertThat(game.getScore()).isEqualTo(90);
    }

    @Test
    public void should_return_300_score_when_each_frame_knock_down_10_pins_on_first_try() throws Exception {
        Game game = new Game();
        for (int num = 1; num <= 12; num++) {
            game.roll(10);
        }
        assertThat(game.getScore()).isEqualTo(300);
    }

    @Test
    public void should_return_155_score_when_each_frame_knock_down_10_pins_on_second_try() throws Exception {
        Game game = new Game();
        for (int num = 1; num <= 20; num++) {
            game.roll(5);
        }
        game.roll(10);
        assertThat(game.getScore()).isEqualTo(155);
    }
}