package pers.lyning.kata.fizzbuzzwhizz;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @org.junit.Rule
    public final ExpectedException expectedEx = ExpectedException.none();

    final Game game = Game.of(3, 5, 7);

    public GameTest() throws Exception {
    }

    /******************** play test start ********************/
    @Test
    public void should_return_1_answer_when_given_1_player_play_the_game() throws Exception {
        List<String> results = game.countOff(1);

        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo("1");
    }

    @Test
    public void should_return_10_answer_when_given_10_players_play_the_game() throws Exception {
        List<String> tResults = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "Whizz", "8", "Fizz", "Buzz");

        List<String> results = game.countOff(tResults.size());

        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(10);
        for (int i = 0; i < results.size(); i++) {
            assertThat(results.get(i)).isEqualTo(tResults.get(i));
        }
    }

    @Test
    public void should_return_100_answer_when_given_100_players_play_the_game() throws Exception {
        List<String> tResults = Arrays.asList(
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

        List<String> results = game.countOff(tResults.size());

        assertThat(results).isNotEmpty();
        assertThat(results.size()).isEqualTo(100);
        for (int i = 0; i < results.size(); i++) {
            assertThat(results.get(i)).isEqualTo(tResults.get(i));
        }
    }

    @Test
    public void should_fail_when_given_less_than_1_player() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("游戏至少需要一名玩家！");

        this.game.countOff(0);
    }

    @Test
    public void should_fail_when_given_2_and_7_were_entered() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("请输入三个不同的个位数字！");

        Game.of(2, 7, null);
    }

    @Test
    public void should_fail_when_contain_unique_numbers_less_than_1() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("数字不能小于1或大于9！");

        Game.of(0, 3, 7);
    }

    @Test
    public void should_fail_when_contain_numbers_greater_than_9() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("数字不能小于1或大于9！");

        Game.of(1, 3, 10);
    }
    /******************** play test end ********************/
}
