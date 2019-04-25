package pers.lyning.kata.marsrover;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Grid {
    private final Range range;
    private final List<Obstacle> obstacles;

    public Grid(Range range) {
        this(range, new ArrayList<>());
    }

    public Grid(Range range, List<Obstacle> obstacles) {
        this.range = range;
        this.obstacles = obstacles;
    }

    public Range getRange() {
        return range;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
