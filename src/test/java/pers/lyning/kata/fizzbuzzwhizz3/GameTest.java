package pers.lyning.kata.fizzbuzzwhizz3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class GameTest {

    @Test
    public void players_1() {
        Game game = new Game(3, 5, 7);
        List<String> results = game.countOff(1);
        assertThat(results).isEqualTo(Arrays.asList("1"));
    }

    @Test
    public void players_10() {
        List<String> givenResults = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "Whizz", "8", "Fizz", "Buzz");
        Game game = new Game(3, 5, 7);
        List<String> results = game.countOff(10);
        assertThat(results).isEqualTo(givenResults);
    }

    @Test
    public void players_100() {
        List<String> givenResults = Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "Whizz", "8", "Fizz", "Buzz",
                "11", "Fizz", "Fizz", "Whizz", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
                "FizzWhizz", "22", "Fizz", "Fizz", "Buzz", "26", "Fizz", "Whizz", "29", "Fizz",
                "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Buzz",
                "41", "FizzWhizz", "Fizz", "44", "FizzBuzz", "46", "47", "Fizz", "Whizz", "Buzz",
                "Fizz", "52", "Fizz", "Fizz", "Buzz", "Whizz", "Fizz", "58", "59", "FizzBuzz",
                "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "BuzzWhizz",
                "71", "Fizz", "Fizz", "74", "FizzBuzz", "76", "Whizz", "Fizz", "79", "Buzz",
                "Fizz", "82", "Fizz", "FizzWhizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
                "Whizz", "92", "Fizz", "94", "Buzz", "Fizz", "97", "Whizz", "Fizz", "Buzz"
        );
        Game game = new Game(3, 5, 7);
        List<String> results = game.countOff(100);
        assertThat(results).isEqualTo(givenResults);
    }
}
