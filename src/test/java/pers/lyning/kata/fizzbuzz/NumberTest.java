package pers.lyning.kata.fizzbuzz;

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
        List<Integer> numbers = Arrays.asList(3, 6, 9, 12, 15, 33, 99);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isFizz()).isTrue();
        }
    }

    @Test
    public void should_return_false_when_number_is_not_divisible_by_3() {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 8, 10, 61, 62);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isFizz()).isFalse();
        }
    }

    @Test
    public void should_return_true_when_number_is_divisible_by_5() {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 30, 45, 55, 100);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isBuzz()).isTrue();
        }
    }

    @Test
    public void should_return_false_when_number_is_not_divisible_by_5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 61, 62);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isBuzz()).isFalse();
        }
    }

    @Test
    public void should_return_true_when_number_is_divisible_by_3_and_5() {
        List<Integer> numbers = Arrays.asList(15, 30, 45, 75);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isFizzBuzz()).isTrue();
        }
    }

    @Test
    public void should_return_false_when_number_is_not_divisible_by_3_and_5() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 31, 32, 51, 52);
        for (Integer num : numbers) {
            Number number = new Number(num);
            assertThat(number.isFizzBuzz()).isFalse();
        }
    }
}
