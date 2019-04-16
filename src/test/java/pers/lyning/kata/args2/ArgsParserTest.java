package pers.lyning.kata.args2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsParserTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_return_true_when_contains_flag() {
        ArgsParser argsParser = new ArgsParser("p#", new String[]{"-p 8080"});
        assertThat(argsParser.hasFlag("p")).isTrue();
    }

    @Test
    public void should_return_false_when_contains_flag() {
        ArgsParser argsParser = new ArgsParser("p#", new String[]{"-p 8080"});
        assertThat(argsParser.hasFlag("q")).isFalse();
    }

    @Test
    public void should_return_8080_when_input_int_value() {
        ArgsParser argsParser = new ArgsParser("p#", new String[]{"-p 8080"});
        assertThat(argsParser.<Integer>getValue("p")).isEqualTo(8080);
    }

    @Test
    public void should_return_int_default_value_0() {
        ArgsParser argsParser = new ArgsParser("p#", new String[]{"-p"});
        assertThat(argsParser.<Integer>getValue("p")).isEqualTo(0);
    }

    @Test
    public void should_return_empty_string() {
        ArgsParser argsParser = new ArgsParser("d*", new String[]{"-d"});
        assertThat(argsParser.<String>getValue("d")).isEqualTo("");
    }

    @Test
    public void should_return_string_value() {
        ArgsParser argsParser = new ArgsParser("d*", new String[]{"-d lyning"});
        assertThat(argsParser.<String>getValue("d")).isEqualTo("lyning");
    }

    @Test
    public void should_return_false() {
        ArgsParser argsParser = new ArgsParser("l", new String[]{"-l"});
        assertThat(argsParser.<Boolean>getValue("l")).isFalse();
    }

    @Test
    public void should_empty_string_arrays() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s"});
        String[] strArr = argsParser.getValue("s");
        assertThat(strArr).isEmpty();
        assertThat(strArr.length).isEqualTo(0);
    }

    @Test
    public void should_return_string_arrays() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s 你 好"});
        String[] strArr = argsParser.getValue("s");
        assertThat(strArr).isNotEmpty();
        assertThat(strArr.length).isEqualTo(2);
        assertThat(strArr[0]).isEqualTo("你");
        assertThat(strArr[1]).isEqualTo("好");
    }

    @Test
    public void should_empty_int_arrays() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i"});
        Integer[] intArr = argsParser.getValue("i");
        assertThat(intArr).isEmpty();
        assertThat(intArr.length).isEqualTo(0);
    }

    @Test
    public void should_return_int_arrays() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i 0 1 2"});
        Integer[] intArr = argsParser.getValue("i");
        assertThat(intArr).isNotEmpty();
        assertThat(intArr.length).isEqualTo(3);
        assertThat(intArr[0]).isEqualTo(0);
        assertThat(intArr[1]).isEqualTo(1);
        assertThat(intArr[2]).isEqualTo(2);
    }

    @Test
    public void should_fail_when_schema_not_found() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("INVALID SCHEMA.");

        ArgsParser argsParser = new ArgsParser("i[^]", new String[]{"-i 0 1 2"});
        argsParser.getValue("i");
    }
}
