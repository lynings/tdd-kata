package pers.lyning.kata.args5;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    @Test
    public void parse_no_args() {
        Args args = Args.parse(new String[]{});
        assertThat(args.size()).isEqualTo(0);
    }

    @Test
    public void parse_no_value() {
        Args args = Args.parse(new String[]{"-l"});
        assertThat(args.size()).isEqualTo(1);
        assertThat(args.hasFlag("l")).isTrue();
        assertThat(args.getValue("l")).isNull();
    }

    @Test
    public void parse_one_args() {
        Args args = Args.parse(new String[]{"-l", "1"});
        assertThat(args.size()).isEqualTo(1);
        assertThat(args.hasFlag("l")).isTrue();
        assertThat(args.getValue("l")).isEqualTo("1");
    }

    @Test
    public void parse_multiple_args() {
        Args args = Args.parse(new String[]{
                "-l", "1",
                "-s", "hello",
                "-i", "10"
        });
        assertThat(args.size()).isEqualTo(3);
        assertThat(args.hasFlag("l")).isTrue();
        assertThat(args.hasFlag("s")).isTrue();
        assertThat(args.hasFlag("i")).isTrue();
        assertThat(args.hasFlag("a")).isFalse();
        assertThat(args.getValue("l")).isEqualTo("1");
        assertThat(args.getValue("s")).isEqualTo("hello");
        assertThat(args.getValue("i")).isEqualTo("10");
    }
}
