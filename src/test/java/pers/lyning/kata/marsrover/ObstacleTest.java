package pers.lyning.kata.marsrover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObstacleTest {

    @Test
    public void isEquals() {
        Obstacle obstacle = new Obstacle(1, 1);
        assertThat(obstacle.isEquals(1, 1)).isTrue();

        assertThat(obstacle.isEquals(1, 2)).isFalse();
    }
}