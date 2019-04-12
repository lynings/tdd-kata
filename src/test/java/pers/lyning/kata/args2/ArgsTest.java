package pers.lyning.kata.args2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    @Test
    public void should_return_false_when_flag_not_found() {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.hasFlag("a")).isFalse();
    }

    @Test
    public void should_return_true_when_existed_flag() {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.hasFlag("s")).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void should_get_value_fail_when_flag_not_found() {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.<String>getValue("a")).isEqualTo("");
    }

    @Test
    public void should_return_empty_string() throws Exception {
        Args args = new Args("s*", new String[]{"-s"});
        assertThat(args.<String>getValue("s")).isEqualTo("");
    }

    @Test
    public void should_return_specified_string() throws Exception {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.<String>getValue("s")).isEqualTo("a");
    }

    @Test
    public void should_return_default_integer_value() throws Exception {
        Args args = new Args("i#", new String[]{"-i"});
        assertThat(args.<Integer>getValue("i")).isEqualTo(0);
    }

    @Test
    public void should_return_specified_integer() throws Exception {
        Args args = new Args("i#", new String[]{"-i", "123"});
        assertThat(args.<Integer>getValue("i")).isEqualTo(123);
    }

    @Test
    public void should_return_default_double_value() throws Exception {
        Args args = new Args("d##", new String[]{"-d"});
        assertThat(args.<Double>getValue("d")).isEqualTo(0.0);
    }

    @Test
    public void should_return_specified_double() throws Exception {
        Args args = new Args("d##", new String[]{"-d", "123.5"});
        assertThat(args.<Double>getValue("d")).isEqualTo(123.5);
    }

    @Test
    public void should_return_default_false_value() throws Exception {
        Args args = new Args("l", new String[]{"-l"});
        assertThat(args.<Boolean>getValue("l")).isFalse();
    }

    @Test
    public void should_return_true() throws Exception {
        Args args = new Args("l", new String[]{"-l", "1"});
        assertThat(args.<Boolean>getValue("l")).isTrue();
    }

    @Test
    public void should_return_default_empty_string_arrays() throws Exception {
        Args args = new Args("s[*]", new String[]{"-s"});
        assertThat(args.<String[]>getValue("s")).isEmpty();
    }

    @Test
    public void should_return_specified_string_arrays() throws Exception {
        Args args = new Args("s[*]", new String[]{"-s", "This is args"});
        String[] values = args.getValue("s");
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo("This");
        assertThat(values[1]).isEqualTo("is");
        assertThat(values[2]).isEqualTo("args");
    }
}
