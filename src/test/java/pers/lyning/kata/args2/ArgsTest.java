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
    public void should_return_specifies_one_string() throws Exception {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.<String>getValue("s")).isEqualTo("a");
    }
}
