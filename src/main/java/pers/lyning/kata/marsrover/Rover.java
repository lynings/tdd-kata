package pers.lyning.kata.marsrover;

/**
 * @author lyning
 */
public class Rover {
    private Position position;
    private final ObstacleDetector obstacleDetector;
    private final String FORWARD = "F";
    private final String BACKWARD = "B";
    private final String TURN_LEFT = "L";
    private final String TURN_RIGHT = "R";

    public Rover(Position position, Grid grid) {
        this.position = position;
        this.obstacleDetector = new ObstacleDetector(grid);
    }

    public Position receive(String[] commands) {
        for (String command : commands) {
            Position nextPosition = this.nextPosition(command);
            if (this.obstacleDetector.check(nextPosition)) {
                this.obstacleDetector.report(nextPosition);
                this.moveToLastPossiblePoint();
                break; // aborts
            }
            this.position = nextPosition;
        }
        return this.position;
    }

    private void moveToLastPossiblePoint() {
        for (Direction direction : Direction.values()) {
            this.position.setDirection(direction);
            Position nextPosition = this.nextPosition(FORWARD);
            if (this.obstacleDetector.check(nextPosition)) {
                this.position = nextPosition;
                break;
            }
        }
    }

    private Position nextPosition(String command) {
        Position position = Position.deepCopy(this.position);
        switch (command) {
            case FORWARD:
                return this.forward(position);
            case BACKWARD:
                return this.backward(position);
            case TURN_LEFT:
                return this.turnLeft(position);
            case TURN_RIGHT:
                return this.turnRight(position);
            default:
                throw new CommandIncorrectException(String.format("command '%s' incorrect!", command));
        }
    }

    private Position forward(Position position) {
        switch (position.getDirection()) {
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
            case WEST:
                position.setX(position.getX() - 1);
                break;
            case EAST:
                position.setX(position.getX() + 1);
                break;
        }
        return position;
    }

    private Position backward(Position position) {
        Direction currentDirection = position.getDirection();
        Direction reverseDirection = DirectionLocator.turn180(position.getDirection());
        position.setDirection(reverseDirection);
        this.forward(position);
        position.setDirection(currentDirection);
        return position;
    }

    private Position turnLeft(Position position) {
        Direction prevPosition = position.getDirection();
        Direction nextDirection = DirectionLocator.turnLeft90(prevPosition);
        position.setDirection(nextDirection);
        return position;
    }

    private Position turnRight(Position position) {
        Direction prevPosition = position.getDirection();
        Direction nextDirection = DirectionLocator.turnRight90(prevPosition);
        position.setDirection(nextDirection);
        return position;
    }
}
