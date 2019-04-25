package pers.lyning.kata.marsrover;

/**
 * @author lyning
 */
public class Position {
    private Integer x;
    private Integer y;
    private Direction direction;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    private Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public static Position deepCopy(Position position) {
        return new Position(position);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
