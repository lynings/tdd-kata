package pers.lyning.kata.marsrover;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class DirectionLocator {
    private static final List<DirectionEnum> directions = Arrays.asList(
            DirectionEnum.NORTH,
            DirectionEnum.WEST,
            DirectionEnum.SOUTH,
            DirectionEnum.EAST
    );

    public static DirectionEnum turn180(DirectionEnum direction) {
        int index = directions.indexOf(direction);
        int nextIndex = (index + 2) % 4;
        return directions.get(nextIndex);
    }

    public static DirectionEnum turnLeft90(DirectionEnum direction) {
        int index = directions.indexOf(direction);
        int nextIndex = (index + 1) % 4;
        return directions.get(nextIndex);
    }

    public static DirectionEnum turnRight90(DirectionEnum direction) {
        int index = directions.indexOf(direction);
        int nextIndex = index == 0
                ? directions.size() - 1
                : index - 1;
        return directions.get(nextIndex);
    }
}
