package pers.lyning.kata.fizzbuzzwhizz;

/**
 * @author lyning
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UniqueNumbers uniqueNumbers = new UniqueNumbers(3, 5, 7);
        Game game = new Game(100, uniqueNumbers);
        game.countOff();
    }
}
