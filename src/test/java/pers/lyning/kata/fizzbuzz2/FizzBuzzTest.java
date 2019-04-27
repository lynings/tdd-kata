package pers.lyning.kata.fizzbuzz2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
@RunWith(Parameterized.class)
public class FizzBuzzTest {

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, "1"},
                {3, "Fizz"},
                {5, "Buzz"},
                {13, "Fizz"},
                {15, "FizzBuzz"},
                {30, "FizzBuzz"},
                {51, "FizzBuzz"},
                {52, "Buzz"},
        };
    }

    private Integer number;
    private String answer;

    public FizzBuzzTest(Integer number, String answer) {
        this.number = number;
        this.answer = answer;
    }

    @Test
    public void say() {
        assertThat(FizzBuzz.say(this.number)).isEqualTo(this.answer);
    }
}