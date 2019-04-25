package pers.lyning.kata.marsrover;

/**
 * @author lyning
 */
public class GridPositioner {
    private Grid grid;

    public GridPositioner(Grid grid) {
        this.grid = grid;
    }

    public Position search(Position position, int steps) {
        switch (position.getDirection()) {
            case NORTH:
                position.setY(this.moveYAxis(position.getY(), steps));
                break;
            case SOUTH:
                position.setY(this.moveYAxis(position.getY(), -steps));
                break;
            case WEST:
                position.setX(this.moveXAxis(position.getX(), -steps));
                break;
            case EAST:
                position.setX(this.moveXAxis(position.getX(), steps));
                break;
        }
        return position;
    }

    private Integer moveXAxis(Integer x, int steps) {
        return Math.abs(x + steps) % this.grid.getRange().getX();
    }

    private Integer moveYAxis(Integer y, int steps) {
        return Math.abs(y + steps) % this.grid.getRange().getY();
    }
}
