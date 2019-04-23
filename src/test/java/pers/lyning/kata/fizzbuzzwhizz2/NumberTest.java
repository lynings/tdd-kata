package pers.lyning.kata.fizzbuzzwhizz2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class NumberTest {

    @Test
    public void should_return_true_when_number_is_divisible_by_3() {
        List<Integer> numbers = Arrays.asList(3, 6, 9, 12, 15, 30, 45, 99);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isDivisibleBy(3)).isTrue();
        }
    }

    @Test
    public void should_return_false_when_number_is_not_divisible_by_3() {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 8, 10, 31, 32, 34);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isDivisibleBy(3)).isFalse();
        }
    }

    @Test
    public void should_return_true_when_number_is_divisible_by_5() {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 35, 75, 100);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isDivisibleBy(5)).isTrue();
        }
    }

    @Test
    public void should_return_false_when_number_is_not_divisible_by_5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 51, 52, 53);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isDivisibleBy(5)).isFalse();
        }
    }


    @Test
    public void should_return_true_when_number_is_divisible_by_7() {
        List<Integer> numbers = Arrays.asList(7, 14, 21, 63, 91);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isDivisibleBy(7)).isTrue();
        }
    }

    @Test
    public void should_return_false_when_number_is_not_divisible_by_7() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 71, 72);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isDivisibleBy(7)).isFalse();
        }
    }
}
