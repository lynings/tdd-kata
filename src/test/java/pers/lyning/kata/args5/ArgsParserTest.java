package pers.lyning.kata.args5;

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
        boolean value = argsParser.getValue("l");
        assertThat(value).isFalse();
    }

    @Test
    public void should_return_true() {
        ArgsParser argsParser = new ArgsParser("l", new String[]{"-l", "true"});
        boolean value = argsParser.getValue("l");
        assertThat(value).isTrue();
    }

    @Test
    public void should_return_empty_string() {
        ArgsParser argsParser = new ArgsParser("s*", new String[]{"-s"});
        String value = argsParser.getValue("s");
        assertThat(value).isEqualTo("");
    }

    @Test
    public void should_return_specified_string() {
        ArgsParser argsParser = new ArgsParser("s*", new String[]{"-s", "lyning"});
        String value = argsParser.getValue("s");
        assertThat(value).isEqualTo("lyning");
    }

    @Test
    public void should_return_0_int() {
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i"});
        Integer value = argsParser.getValue("i");
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void should_return_specified_int_value() {
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i", "123"});
        Integer value = argsParser.getValue("i");
        assertThat(value).isEqualTo(123);
    }

    @Test
    public void should_fail_when_int_value_contain_string() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be an int type.");
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i", "kata"});
        argsParser.getValue("i");
    }

    @Test
    public void should_return_empty_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i"});
        Integer[] intArr = argsParser.getValue("i");
        assertThat(intArr).isEmpty();
    }

    @Test
    public void should_return_specified_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "-1 0 1"});
        Integer[] intArr = argsParser.getValue("i");
        assertThat(intArr).isNotEmpty();
        assertThat(intArr.length).isEqualTo(3);
        assertThat(intArr[0]).isEqualTo(-1);
        assertThat(intArr[1]).isEqualTo(0);
        assertThat(intArr[2]).isEqualTo(1);
    }

    @Test
    public void should_fail_when_int_array_contains_string() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be an int type.");

        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "-1 0 1 a"});
        argsParser.getValue("i");
    }

    @Test
    public void should_return_empty_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s"});
        String[] strArr = argsParser.getValue("s");
        assertThat(strArr).isEmpty();
    }

    @Test
    public void should_return_specified_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s", "this is code kata"});
        String[] strArr = argsParser.getValue("s");
        assertThat(strArr).isNotEmpty();
        assertThat(strArr.length).isEqualTo(4);
        assertThat(strArr[0]).isEqualTo("this");
        assertThat(strArr[1]).isEqualTo("is");
        assertThat(strArr[2]).isEqualTo("code");
        assertThat(strArr[3]).isEqualTo("kata");
    }

    @Test
    public void should_fail_when_schema_not_found() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("schema not found.");

        ArgsParser argsParser = new ArgsParser("w[^^]", new String[]{"-w", "this is code kata"});
        argsParser.getValue("w");
    }
}
