package pers.lyning.kata.marsrover;

/**
 * @author lyning
 */
public class Obstacle {
    private final Integer x;
    private final Integer y;

    public Obstacle(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public boolean isEquals(Integer x, Integer y) {
        return this.x.equals(x) && this.y.equals(y);
    }
}
