package pers.lyning.kata.marsrover;

/**
 * @author lyning
 */
public class CommandIncorrectException extends RuntimeException{

    public CommandIncorrectException(String message) {
        super(message);
    }
}
