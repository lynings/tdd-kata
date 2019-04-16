package pers.lyning.kata.args4;

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
        ArgsParser argsParser = new ArgsParser("l", new String[]{"-l", "1"});
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
        ArgsParser argsParser = new ArgsParser("s*", new String[]{"-s", "this is code kata"});
        String value = argsParser.getValue("s");
        assertThat(value).isEqualTo("this is code kata");
    }

    @Test
    public void should_return_default_int_value() {
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i"});
        Integer value = argsParser.getValue("i");
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void should_return_specified_int() {
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i", "1230"});
        Integer value = argsParser.getValue("i");
        assertThat(value).isEqualTo(1230);
    }

    @Test
    public void should_return_default_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s"});
        String[] stringArr = argsParser.getValue("s");
        assertThat(stringArr).isEmpty();
        assertThat(stringArr.length).isEqualTo(0);
    }

    @Test
    public void should_return_specified_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s", "this is code kata"});
        String[] stringArr = argsParser.getValue("s");
        assertThat(stringArr).isNotEmpty();
        assertThat(stringArr.length).isEqualTo(4);
        assertThat(stringArr[0]).isEqualTo("this");
        assertThat(stringArr[1]).isEqualTo("is");
        assertThat(stringArr[2]).isEqualTo("code");
        assertThat(stringArr[3]).isEqualTo("kata");
    }

    @Test
    public void should_return_default_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i"});
        Integer[] intArr = argsParser.getValue("i");
        assertThat(intArr).isEmpty();
        assertThat(intArr.length).isEqualTo(0);
    }

    @Test
    public void should_return_specified_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "-1 0 1 2"});
        Integer[] intArr = argsParser.getValue("i");
        assertThat(intArr).isNotEmpty();
        assertThat(intArr.length).isEqualTo(4);
        assertThat(intArr[0]).isEqualTo(-1);
        assertThat(intArr[1]).isEqualTo(0);
        assertThat(intArr[2]).isEqualTo(1);
        assertThat(intArr[3]).isEqualTo(2);
    }

    @Test
    public void should_fail_when_schema_not_found() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("schema not found");
        ArgsParser argsParser = new ArgsParser("i[^]", new String[]{"-i", "-1 0 1 2"});
        argsParser.getValue("i");
    }

    @Test
    public void should_fail_when_int_contain_string_value() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be an int type");
        ArgsParser argsParser = new ArgsParser("i#", new String[]{"-i", "abc"});
        argsParser.getValue("i");
    }

    @Test
    public void should_fail_when_int_array_contain_string_value() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be an int type");
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "-1 0 1 a"});
        argsParser.getValue("i");
    }
}
