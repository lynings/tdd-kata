package pers.lyning.kata.marsrover;

/**
 * @author lyning
 */
public class ObstacleDetector {
    private final Grid grid;

    public ObstacleDetector(Grid grid) {
        this.grid = grid;
    }

    public boolean check(Position position) {
        return this.grid
                .getObstacles()
                .stream()
                .filter(obstacle -> obstacle.isEquals(position.getX(), position.getY()))
                .findAny()
                .isPresent();
    }

    public void report(Position position) {
        System.out.println(String.format("position(%d,%d) encounters an obstacle!", position.getX(), position.getY()));
    }
}
