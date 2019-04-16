package pers.lyning.kata.args6;

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
        assertThat(argsParser.<Boolean>getValue("l")).isFalse();
    }

    @Test
    public void should_return_true() {
        ArgsParser argsParser = new ArgsParser("l", new String[]{"-l", "1"});
        assertThat(argsParser.<Boolean>getValue("l")).isTrue();
    }

    @Test
    public void should_return_empty_string() {
        ArgsParser argsParser = new ArgsParser("s*", new String[]{"-s"});
        assertThat(argsParser.<String>getValue("s")).isEqualTo("");
    }

    @Test
    public void should_return_specified_string() {
        ArgsParser argsParser = new ArgsParser("s*", new String[]{"-s", "hello"});
        assertThat(argsParser.<String>getValue("s")).isEqualTo("hello");
    }

    @Test
    public void should_return_int_default_value() {
        ArgsParser argsParser = new ArgsParser("d#", new String[]{"-d"});
        assertThat(argsParser.<Integer>getValue("d")).isEqualTo(0);
    }

    @Test
    public void should_return_specified_int_value() {
        ArgsParser argsParser = new ArgsParser("d#", new String[]{"-d", "8080"});
        assertThat(argsParser.<Integer>getValue("d")).isEqualTo(8080);
    }

    @Test
    public void should_fail_when_int_value_contains_string_value() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be an int type");
        ArgsParser argsParser = new ArgsParser("d#", new String[]{"-d", "a"});
        argsParser.<Integer>getValue("d");
    }

    @Test
    public void should_return_empty_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s"});
        assertThat(argsParser.<String[]>getValue("s")).isEmpty();
    }

    @Test
    public void should_return_specified_string_array() {
        ArgsParser argsParser = new ArgsParser("s[*]", new String[]{"-s", "this is code kata"});
        assertThat(argsParser.<String[]>getValue("s")).isNotEmpty();
        assertThat(argsParser.<String[]>getValue("s").length).isEqualTo(4);
        assertThat(argsParser.<String[]>getValue("s")[0]).isEqualTo("this");
        assertThat(argsParser.<String[]>getValue("s")[1]).isEqualTo("is");
        assertThat(argsParser.<String[]>getValue("s")[2]).isEqualTo("code");
        assertThat(argsParser.<String[]>getValue("s")[3]).isEqualTo("kata");
    }


    @Test
    public void should_return_empty_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i"});
        assertThat(argsParser.<Integer[]>getValue("i")).isEmpty();
    }

    @Test
    public void should_return_specified_int_array() {
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "-1 0 1"});
        assertThat(argsParser.<Integer[]>getValue("i")).isNotEmpty();
        assertThat(argsParser.<Integer[]>getValue("i").length).isEqualTo(3);
        assertThat(argsParser.<Integer[]>getValue("i")[0]).isEqualTo(-1);
        assertThat(argsParser.<Integer[]>getValue("i")[1]).isEqualTo(0);
        assertThat(argsParser.<Integer[]>getValue("i")[2]).isEqualTo(1);
    }

    @Test
    public void should_fail_when_int_array_contains_string_value() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("value should be an int type");
        ArgsParser argsParser = new ArgsParser("i[#]", new String[]{"-i", "1 2 a"});
        argsParser.<Integer[]>getValue("i");
    }

    @Test
    public void multiple_flag() {
        ArgsParser argsParser = new ArgsParser("i[#],s*,r[*]", new String[]{"-i", "-1 0 1", "-s", "tdder", "-r", "go go go"});
        assertThat(argsParser.<Integer[]>getValue("i")).isNotEmpty();
        assertThat(argsParser.<Integer[]>getValue("i").length).isEqualTo(3);
        assertThat(argsParser.<Integer[]>getValue("i")[0]).isEqualTo(-1);
        assertThat(argsParser.<Integer[]>getValue("i")[1]).isEqualTo(0);
        assertThat(argsParser.<Integer[]>getValue("i")[2]).isEqualTo(1);

        assertThat(argsParser.<String>getValue("s")).isEqualTo("tdder");

        assertThat(argsParser.<String[]>getValue("r").length).isEqualTo(3);
        assertThat(argsParser.<String[]>getValue("r")[0]).isEqualTo("go");
        assertThat(argsParser.<String[]>getValue("r")[1]).isEqualTo("go");
        assertThat(argsParser.<String[]>getValue("r")[2]).isEqualTo("go");
    }

    @Test
    public void should_fail_when_schema_not_found() {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("schema not found");
        ArgsParser argsParser = new ArgsParser("i[^^]", new String[]{"-i", "-1 0 1"});
        argsParser.getValue("i");
    }
}
