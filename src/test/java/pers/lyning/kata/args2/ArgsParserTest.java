package pers.lyning.kata.args2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsParserTest {

    @Rule
    public final ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_return_false_when_flag_not_found() {
        ArgsParser parser = new ArgsParser("s*", new String[]{"-s", "a"});
        assertThat(parser.hasFlag("a")).isFalse();
    }

    @Test
    public void should_return_true_when_existed_flag() {
        ArgsParser parser = new ArgsParser("s*", new String[]{"-s", "a"});
        assertThat(parser.hasFlag("s")).isTrue();
    }

    @Test(expected = ArgsException.class)
    public void should_get_value_fail_when_flag_not_found() {
        ArgsParser parser = new ArgsParser("s*", new String[]{"-s", "a"});
        assertThat(parser.<String>getValue("a")).isEqualTo("");
    }

    @Test(expected = ArgsException.class)
    public void should_fail_when_value_parser_not_implemented() {
        ArgsParser parser = new ArgsParser("s^^^", new String[]{"-s", "test"});
        parser.getValue("s");
    }

    @Test(expected = ArgsException.class)
    public void should_fail_when_value_parser_not_found() {
        ArgsParser parser = new ArgsParser("s*", new String[]{"-s", "test"});
        parser.getValue("a");
    }

    @Test
    public void should_return_empty_string() throws Exception {
        ArgsParser parser = new ArgsParser("s*", new String[]{"-s"});
        assertThat(parser.<String>getValue("s")).isEqualTo("");
    }

    @Test
    public void should_return_specified_string() throws Exception {
        ArgsParser parser = new ArgsParser("s*", new String[]{"-s", "a"});
        assertThat(parser.<String>getValue("s")).isEqualTo("a");
    }

    @Test
    public void should_fail_when_input_incorrect_integer_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an integer，such as -i 1");
        ArgsParser parser = new ArgsParser("i#", new String[]{"-i", "a"});
        parser.<Integer>getValue("i");
    }

    @Test
    public void should_return_default_integer_value() throws Exception {
        ArgsParser parser = new ArgsParser("i#", new String[]{"-i"});
        assertThat(parser.<Integer>getValue("i")).isEqualTo(0);
    }

    @Test
    public void should_return_specified_integer() throws Exception {
        ArgsParser parser = new ArgsParser("i#", new String[]{"-i", "123"});
        assertThat(parser.<Integer>getValue("i")).isEqualTo(123);
    }

    @Test
    public void should_return_default_double_value() throws Exception {
        ArgsParser parser = new ArgsParser("d##", new String[]{"-d"});
        assertThat(parser.<Double>getValue("d")).isEqualTo(0.0);
    }

    @Test
    public void should_fail_when_input_incorrect_double_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an double，such as -d 2.5");
        ArgsParser parser = new ArgsParser("d##", new String[]{"-d", "a"});
        parser.<Integer>getValue("d");
    }

    @Test
    public void should_return_specified_double() throws Exception {
        ArgsParser parser = new ArgsParser("d##", new String[]{"-d", "123.5"});
        assertThat(parser.<Double>getValue("d")).isEqualTo(123.5);
    }

    @Test
    public void should_return_false_not_exist_boolean_value() throws Exception {
        ArgsParser parser = new ArgsParser("l", new String[]{"-l"});
        assertThat(parser.<Boolean>getValue("l")).isFalse();
    }

    @Test
    public void should_return_true_when_existed_boolean_value() throws Exception {
        ArgsParser parser = new ArgsParser("l", new String[]{"-l", "1"});
        assertThat(parser.<Boolean>getValue("l")).isTrue();
    }

    @Test
    public void should_return_default_empty_string_arrays() throws Exception {
        ArgsParser parser = new ArgsParser("s[*]", new String[]{"-s"});
        assertThat(parser.<String[]>getValue("s")).isEmpty();
    }

    @Test
    public void should_return_specified_string_arrays() throws Exception {
        ArgsParser parser = new ArgsParser("s[*]", new String[]{"-s", "This is parser"});
        String[] values = parser.getValue("s");
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo("This");
        assertThat(values[1]).isEqualTo("is");
        assertThat(values[2]).isEqualTo("parser");
    }

    @Test
    public void should_return_default_empty_int_arrays() throws Exception {
        ArgsParser parser = new ArgsParser("i[#]", new String[]{"-i"});
        assertThat(parser.<Integer[]>getValue("i")).isEmpty();
    }

    @Test
    public void should_return_specified_int_arrays() throws Exception {
        ArgsParser parser = new ArgsParser("i[#]", new String[]{"-i", "0 1 -2"});
        Integer[] values = parser.getValue("i");
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo(0);
        assertThat(values[1]).isEqualTo(1);
        assertThat(values[2]).isEqualTo(-2);
    }

    @Test
    public void should_fail_when_input_incorrect_int_arrays_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an int arrays，such as -i[#] 0 1 2");
        ArgsParser parser = new ArgsParser("i[#]", new String[]{"-i", "0 1 2 a"});
        parser.<Integer>getValue("i");
    }

    @Test
    public void should_return_default_empty_double_arrays() throws Exception {
        ArgsParser parser = new ArgsParser("d[##]", new String[]{"-d"});
        assertThat(parser.<Double[]>getValue("d")).isEmpty();
    }

    @Test
    public void should_return_specified_double_arrays() throws Exception {
        ArgsParser parser = new ArgsParser("d[##]", new String[]{"-d", "0 1.5 -2.5"});
        Double[] values = parser.getValue("d");
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo(0.0);
        assertThat(values[1]).isEqualTo(1.5);
        assertThat(values[2]).isEqualTo(-2.5);
    }

    @Test
    public void should_fail_when_input_incorrect_double_arrays_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an double arrays，such as -d[##] 1.0 2.5 3.14");
        ArgsParser parser = new ArgsParser("d[##]", new String[]{"-d", "1.0 2.5 3.14 a"});
        parser.<Integer>getValue("d");
    }

    @Test
    public void should_return_default_empty_map() throws Exception {
        ArgsParser parser = new ArgsParser("m[&&]", new String[]{"-m"});
        assertThat(parser.<Map<String, String>>getValue("m")).isEmpty();
    }

    @Test
    public void should_return_specified_map() throws Exception {
        ArgsParser parser = new ArgsParser("m[&&]", new String[]{"-m", "name:lyning,age:25"});
        Map<String, String> values = parser.getValue("m");
        assertThat(values).isNotEmpty();
        assertThat(values.size()).isEqualTo(2);
        assertThat(values.get("name")).isEqualTo("lyning");
        assertThat(values.get("age")).isEqualTo("25");
    }

    @Test
    public void should_fail_when_input_incorrect_map_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an map，such as -m[&&] key1:val1,key2:val2,...");
        ArgsParser parser = new ArgsParser("m[&&]", new String[]{"-m", "name:lyning,age"});
        parser.<Integer>getValue("m");
    }

    @Test
    public void should_return_default_empty_set() throws Exception {
        ArgsParser parser = new ArgsParser("s[&]", new String[]{"-s"});
        assertThat(parser.<Set<String>>getValue("s")).isEmpty();
    }

    @Test
    public void should_return_specified_set() throws Exception {
        ArgsParser parser = new ArgsParser("s[&]", new String[]{"-s", "a a b b c c"});
        Set<String> values = parser.getValue("s");
        assertThat(values).isNotEmpty();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.contains("a")).isTrue();
        assertThat(values.contains("b")).isTrue();
        assertThat(values.contains("c")).isTrue();
    }

    @Test
    public void multiple_flag() {
        ArgsParser parser = new ArgsParser("a*,b#,c##,d[*],e[#],f[##],g[&],h[&&],", new String[]{
                "-a", "你好",
                "-b", "10",
                "-c", "3.14",
                "-d", "你 好 呀",
                "-e", "1 2 3",
                "-f", "1.0 2.0 3.5",
                "-g", "a b c c",
                "-h", "name:lyning,age:25",
        });
        assertThat(parser.<String>getValue("a")).isEqualTo("你好");
        assertThat(parser.<Integer>getValue("b")).isEqualTo(10);
        assertThat(parser.<Double>getValue("c")).isEqualTo(3.14);

        String[] stringArr = parser.getValue("d");
        assertThat(stringArr.length).isEqualTo(3);
        assertThat(stringArr[0]).isEqualTo("你");
        assertThat(stringArr[1]).isEqualTo("好");
        assertThat(stringArr[2]).isEqualTo("呀");

        Integer[] intArr = parser.getValue("e");
        assertThat(intArr.length).isEqualTo(3);
        assertThat(intArr[0]).isEqualTo(1);
        assertThat(intArr[1]).isEqualTo(2);
        assertThat(intArr[2]).isEqualTo(3);

        Double[] doubleArr = parser.getValue("f");
        assertThat(doubleArr.length).isEqualTo(3);
        assertThat(doubleArr[0]).isEqualTo(1.0);
        assertThat(doubleArr[1]).isEqualTo(2.0);
        assertThat(doubleArr[2]).isEqualTo(3.5);

        Set<String> set = parser.getValue("g");
        assertThat(set.size()).isEqualTo(3);
        assertThat(set.contains("a")).isTrue();
        assertThat(set.contains("b")).isTrue();
        assertThat(set.contains("c")).isTrue();

        Map<String, String> map = parser.getValue("h");
        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get("name")).isEqualTo("lyning");
        assertThat(map.get("age")).isEqualTo("25");
    }
}
