package pers.lyning.kata.args3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    /***************** hasFlag test start ***************/
    @Test
    public void has_flag_when_parse_one_args() {
        Args args = Args.parse(new String[]{"-s", "hello"});
        assertThat(args.hasFlag("s")).isTrue();
        assertThat(args.hasFlag("hello")).isFalse();
    }

    @Test
    public void has_flag_when_parse_multiple_args() {
        Args args = Args.parse(new String[]{"-s", "hello", "-i", "10"});
        assertThat(args.hasFlag("s")).isTrue();
        assertThat(args.hasFlag("i")).isTrue();
        assertThat(args.hasFlag("hello")).isFalse();
        assertThat(args.hasFlag("10")).isFalse();
    }
    /***************** hasFlag test end ***************/


    /***************** get test start ***************/
    @Test
    public void get_value() {
        Args args = Args.parse(new String[]{"-s", "hello", "-i", "10", "-l"});
        assertThat(args.getValue("s")).isEqualTo("hello");
        assertThat(args.getValue("i")).isEqualTo("10");
        assertThat(args.getValue("l")).isNull();
    }
    /***************** get test end ***************/
}
