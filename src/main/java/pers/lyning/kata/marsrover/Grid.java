package pers.lyning.kata.marsrover;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class Grid {
    private final List<Obstacle> obstacles;
    private final Range range;

    public Grid(Range range) {
        this(range, new ArrayList<>());
    }

    public Grid(Range range, List<Obstacle> obstacles) {
        this.range = range;
        this.obstacles = obstacles;
    }

    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }

    public Range getRange() {
        return this.range;
    }
}
