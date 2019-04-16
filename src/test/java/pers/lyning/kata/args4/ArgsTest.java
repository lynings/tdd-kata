package pers.lyning.kata.args4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    @Test
    public void parse_nothing_args() {
        Args args = Args.parse(new String[]{});
        assertThat(args.size()).isEqualTo(0);
    }

    @Test
    public void parse_null_value() {
        Args args = Args.parse(new String[]{"-l"});
        assertThat(args.size()).isEqualTo(1);
        assertThat(args.getValue("l")).isNull();
    }

    @Test
    public void parse_has_flag() {
        Args args = Args.parse(new String[]{"-l"});
        assertThat(args.size()).isEqualTo(1);
        assertThat(args.hasFlag("l")).isTrue();
        assertThat(args.getValue("l")).isNull();
    }
}
