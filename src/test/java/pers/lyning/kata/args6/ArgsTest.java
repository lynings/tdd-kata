package pers.lyning.kata.args6;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    @Test
    public void parse_no_args() {
        Args args = Args.parse(new String[]{""});
        assertThat(args.size()).isEqualTo(0);
    }

    @Test
    public void parse_no_value() {
        Args args = Args.parse(new String[]{"-s"});
        assertThat(args.size()).isEqualTo(1);
        assertThat(args.getValue("s")).isNull();
    }

    @Test
    public void parse_one_args() {
        Args args = Args.parse(new String[]{"-s", "hello"});
        assertThat(args.size()).isEqualTo(1);
        assertThat(args.getValue("s")).isEqualTo("hello");
    }

    @Test
    public void parse_multiple_args() {
        Args args = Args.parse(new String[]{"-s", "hello", "-p", "8080", "-d", "1.5"});
        assertThat(args.size()).isEqualTo(3);
        assertThat(args.getValue("s")).isEqualTo("hello");
        assertThat(args.getValue("p")).isEqualTo("8080");
        assertThat(args.getValue("d")).isEqualTo("1.5");
    }
}
