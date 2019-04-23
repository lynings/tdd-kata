package pers.lyning.kata.fizzbuzz;

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
        Game game = new Game(1);
        List<String> results = game.play();
        assertThat(results).isEqualTo(Arrays.asList("1"));
    }

    @Test
    public void players_100() {
        List<String> givenResults = Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "Fizz", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
                "Fizz", "22", "Fizz", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz",
                "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Fizz", "Buzz", "41",
                "Fizz", "Fizz", "44", "FizzBuzz", "46", "47", "Fizz", "49", "Buzz",
                "Fizz", "Buzz", "Fizz", "Fizz", "Buzz", "Buzz", "Fizz", "Buzz", "Buzz", "FizzBuzz",
                "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "Buzz",
                "71", "Fizz", "Fizz", "74", "FizzBuzz", "76", "77", "Fizz", "79", "Buzz",
                "Fizz", "82", "Fizz", "Fizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz",
                "91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz"
        );
        Game game = new Game(100);
        List<String> results = game.play();
        assertThat(results).isEqualTo(givenResults);
    }
}
