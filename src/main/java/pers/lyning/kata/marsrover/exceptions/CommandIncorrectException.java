package pers.lyning.kata.marsrover.exceptions;

/**
 * @author lyning
 */
public class CommandIncorrectException extends RuntimeException{

    public CommandIncorrectException(String message) {
        super(message);
    }
}
