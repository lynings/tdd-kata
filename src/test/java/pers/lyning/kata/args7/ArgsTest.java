package pers.lyning.kata.args7;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    @Test
    public void should_return_true_when_argument_contains_l_flag() {
        // given
        String[] arguments = new String[]{"-l"};
        Args args = Args.parse(arguments);
        // when
        boolean result = args.hasFlag("l");
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void should_return_true_when_argument_contains_p_flag() {
        // given
        String[] arguments = new String[]{"-p", "8080"};
        Args args = Args.parse(arguments);
        // when
        boolean result = args.hasFlag("p");
        // then
        assertThat(result).isTrue();
    }

    @Test
    public void should_return_value_when_value_is_not_null() {
        // given
        String[] arguments = new String[]{"-p", "8080"};
        Args args = Args.parse(arguments);
        // when
        String value = args.getValue("p");
        // then
        assertThat(value).isEqualTo("8080");
    }

    @Test
    public void should_return_null_when_value_is_null() {
        // given
        String[] arguments = new String[]{"-p"};
        Args args = Args.parse(arguments);
        // when
        String value = args.getValue("p");
        // then
        assertThat(value).isNull();
    }
}
