package pers.lyning.kata.marsrover;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ObstacleDetectorTest {

    @Test
    public void should_return_true_when_exist_obstacle() {
        Grid grid = new Grid(new Range(5, 5), Arrays.asList(new Obstacle(1, 1)));
        ObstacleDetector obstacleDetector = new ObstacleDetector(grid);
        Position position = new Position(1, 1);
        boolean checkResult = obstacleDetector.check(position);
        assertThat(checkResult).isTrue();
    }

    @Test
    public void should_return_false_when_not_exist_obstacle() {
        Grid grid = new Grid(new Range(5, 5), Arrays.asList(new Obstacle(1, 1)));
        ObstacleDetector obstacleDetector = new ObstacleDetector(grid);
        Position position = new Position(2, 2);
        boolean checkResult = obstacleDetector.check(position);
        assertThat(checkResult).isFalse();
    }
}
