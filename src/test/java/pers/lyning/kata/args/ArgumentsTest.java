package pers.lyning.kata.args;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgumentsTest {

    @Test
    public void should_return_string_when_args_is_minus_s_xxx() {
        String args = "-s Hello World!!!";
        Arguments arguments = new Arguments(args);
        String output = arguments.getValue("s");
        assertThat(output).isEqualTo("Hello World!!!");
    }

    @Test
    public void should_return_integer_when_args_is_minus_n_xxx() {
        String args = "-i 123";
        Arguments arguments = new Arguments(args);
        Integer output = arguments.getValue("i");
        assertThat(output).isEqualTo(123);
    }

    @Test
    public void should_return_multiple_result_when_args_is_minus_n_and_minus_s() {
        String args = "-s Hello World!!! -i 123";
        Arguments arguments = new Arguments(args);

        String resultString = arguments.getValue("s");
        assertThat(resultString).isEqualTo("Hello World!!!");

        Integer resultNumber = arguments.getValue("i");
        assertThat(resultNumber).isEqualTo(123);
    }

    @Test
    public void should_return_string_list_when_args_is_minus_g_xxx() {
        String args = "-g Hello World!!!";
        Arguments arguments = new Arguments(args);

        List<String> list = arguments.getValue("g");
        assertThat(list).isNotEmpty();
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo("Hello");
        assertThat(list.get(1)).isEqualTo("World!!!");
    }

    @Test
    public void should_return_number_list_when_args_is_minus_d_xxx() {
        String args = "-d 1 -2 -3 4 10";
        Arguments arguments = new Arguments(args);

        List<Integer> list = arguments.getValue("d");
        assertThat(list).isNotEmpty();
        assertThat(list.size()).isEqualTo(5);
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(-2);
        assertThat(list.get(2)).isEqualTo(-3);
        assertThat(list.get(3)).isEqualTo(4);
        assertThat(list.get(4)).isEqualTo(10);
    }
}
