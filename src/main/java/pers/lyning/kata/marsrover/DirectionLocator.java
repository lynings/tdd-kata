package pers.lyning.kata.marsrover;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class DirectionLocator {
    private static final List<Direction> directions = Arrays.asList(
            Direction.NORTH,
            Direction.WEST,
            Direction.SOUTH,
            Direction.EAST
    );

    public static Direction turn180(Direction direction) {
        int index = directions.indexOf(direction);
        int nextIndex = (index + 2) % 4;
        return directions.get(nextIndex);
    }

    public static Direction turnLeft90(Direction direction) {
        int index = directions.indexOf(direction);
        int nextIndex = (index + 1) % 4;
        return directions.get(nextIndex);
    }

    public static Direction turnRight90(Direction direction) {
        int index = directions.indexOf(direction);
        int nextIndex = index == 0
                ? directions.size() - 1
                : index - 1;
        return directions.get(nextIndex);
    }
}
