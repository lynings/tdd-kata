package pers.lyning.kata.marsrover;

import pers.lyning.kata.marsrover.exceptions.CommandIncorrectException;

import java.util.Arrays;
import java.util.Optional;

import static pers.lyning.kata.marsrover.constants.CommandConstant.*;

/**
 * @author lyning
 */
public class Rover {
    private final GridPositioner gridPositioner;
    private final ObstacleDetector obstacleDetector;
    private Position position;

    public Rover(Position initialPosition, Grid grid) {
        this.position = initialPosition;
        this.gridPositioner = new GridPositioner(grid);
        this.obstacleDetector = new ObstacleDetector(grid);
    }

    public Position receive(char ...commands) {
        for (char command : commands) {
            Position nextPosition = this.nextPosition(command);
            if (this.obstacleDetector.check(nextPosition)) {
                this.obstacleDetector.report(nextPosition);
                this.moveToPossiblePoint();
                break; // aborts
            }
            this.position = nextPosition;
        }
        return this.position;
    }

    private void moveToPossiblePoint() {
        Optional<Position> positionOptional = Arrays.asList(DirectionEnum.values())
                .stream()
                .filter(direction -> direction != this.position.getDirection())
                .map(direction -> {
                    this.position.setDirection(direction);
                    return this.nextPosition(FORWARD);
                })
                .filter(position -> !this.obstacleDetector.check(position))
                .findAny();
        this.position = positionOptional.get();
    }

    private Position nextPosition(char command) {
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
        int steps = 1;
        Position nextPosition = this.gridPositioner.search(position, steps);
        return nextPosition;
    }

    private Position backward(Position position) {
        DirectionEnum currentDirection = position.getDirection();
        DirectionEnum reverseDirection = DirectionLocator.turn180(position.getDirection());
        position.setDirection(reverseDirection);
        this.forward(position);
        position.setDirection(currentDirection);
        return position;
    }

    private Position turnLeft(Position position) {
        DirectionEnum currentPosition = position.getDirection();
        DirectionEnum nextDirection = DirectionLocator.turnLeft90(currentPosition);
        position.setDirection(nextDirection);
        return position;
    }

    private Position turnRight(Position position) {
        DirectionEnum currentPosition = position.getDirection();
        DirectionEnum nextDirection = DirectionLocator.turnRight90(currentPosition);
        position.setDirection(nextDirection);
        return position;
    }
}
