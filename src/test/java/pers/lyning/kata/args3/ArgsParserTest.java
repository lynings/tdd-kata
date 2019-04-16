package pers.lyning.kata.args3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsParserTest {

    @Rule
    public final ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_return_false() {
        ArgsParser argsParser = new ArgsParser("l", new String[]{"-l"});
        Boolean value = argsParser.getValue("l");
        assertThat(value).isFalse();
    }

    @Test
    public void should_return_true() {
        ArgsParser argsParser = new ArgsParser("l", new String[]{"-l", "1"});
        Boolean value = argsParser.getValue("l");
        assertThat(value).isTrue();
    }

    @Test
    public void should_return_default_empty_string() {
        ArgsParser argsParser = new ArgsParser("s*", new String[]{"-s"});
        String value = argsParser.getValue("s");
        assertThat(value).isEqualTo("");
    }

    @Test
    public void should_return_specified_string_value() {
        ArgsParser argsParser = new ArgsParser("s*", new String[]{"-s", "hello"});
        String value = argsParser.getValue("s");
        assertThat(value).isEqualTo("hello");
    }

    @Test
    public void should_return_default_0_int_value() {
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i"});
        Integer value = argsParser.getValue("i");
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void should_return_specified_int_value() {
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i", "10"});
        Integer value = argsParser.getValue("i");
        assertThat(value).isEqualTo(10);
    }

    @Test
    public void should_return_default_empty_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s"});
        String[] valueArr = argsParser.getValue("s");
        assertThat(valueArr).isEmpty();
    }

    @Test
    public void should_return_specified_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s", "a b c"});
        String[] valueArr = argsParser.getValue("s");
        assertThat(valueArr).isNotEmpty();
        assertThat(valueArr.length).isEqualTo(3);
        assertThat(valueArr[0]).isEqualTo("a");
        assertThat(valueArr[1]).isEqualTo("b");
        assertThat(valueArr[2]).isEqualTo("c");
    }

    @Test
    public void should_return_default_empty_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i"});
        Integer[] valueArr = argsParser.getValue("i");
        assertThat(valueArr).isEmpty();
    }

    @Test
    public void should_return_specified_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "-1 1 -2"});
        Integer[] valueArr = argsParser.getValue("i");
        assertThat(valueArr).isNotEmpty();
        assertThat(valueArr.length).isEqualTo(3);
        assertThat(valueArr[0]).isEqualTo(-1);
        assertThat(valueArr[1]).isEqualTo(1);
        assertThat(valueArr[2]).isEqualTo(-2);
    }

    @Test
    public void should_fail_when_schema_not_found() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("schema not found.");
        ArgsParser argsParser = new ArgsParser("z[^]", new String[]{"-z", "-1 1 -2"});
        argsParser.getValue("z");
    }

    @Test
    public void should_fail_when_int_value_contain_string() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be int type.");
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i", "a"});
        argsParser.getValue("i");
    }

    @Test
    public void should_fail_when_int_array_contain_string() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be int type.");
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "1 2 3 a"});
        argsParser.getValue("i");
    }
}
