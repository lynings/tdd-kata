package pers.lyning.kata.marsrover;

/**
 * @author lyning
 */
public class Position {
    private Integer x;
    private Integer y;
    private DirectionEnum direction;

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position(Integer x, Integer y, DirectionEnum direction) {
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

    public DirectionEnum getDirection() {
        return this.direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
