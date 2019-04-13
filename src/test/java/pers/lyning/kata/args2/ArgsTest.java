package pers.lyning.kata.args2;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    @Test
    public void should_return_false_when_flag_not_found() {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.hasFlag("a")).isFalse();
    }

    @Test
    public void should_return_true_when_existed_flag() {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.hasFlag("s")).isTrue();
    }

    @Test(expected = ArgsException.class)
    public void should_get_value_fail_when_flag_not_found() {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.<String>getValue("a")).isEqualTo("");
    }

    @Test(expected = ArgsException.class)
    public void should_fail_when_value_parser_not_implemented() {
        new Args("s^^^", new String[]{"-s", "test"});
    }

    @Test(expected = ArgsException.class)
    public void should_fail_when_value_parser_not_found() {
        Args args = new Args("s*", new String[]{"-s", "test"});
        args.getValue("a");
    }

    @Test
    public void should_return_empty_string() throws Exception {
        Args args = new Args("s*", new String[]{"-s"});
        assertThat(args.<String>getValue("s")).isEqualTo("");
    }

    @Test
    public void should_return_specified_string() throws Exception {
        Args args = new Args("s*", new String[]{"-s", "a"});
        assertThat(args.<String>getValue("s")).isEqualTo("a");
    }

    @Test
    public void should_return_default_integer_value() throws Exception {
        Args args = new Args("i#", new String[]{"-i"});
        assertThat(args.<Integer>getValue("i")).isEqualTo(0);
    }

    @Test
    public void should_return_specified_integer() throws Exception {
        Args args = new Args("i#", new String[]{"-i", "123"});
        assertThat(args.<Integer>getValue("i")).isEqualTo(123);
    }

    @Test
    public void should_return_default_double_value() throws Exception {
        Args args = new Args("d##", new String[]{"-d"});
        assertThat(args.<Double>getValue("d")).isEqualTo(0.0);
    }

    @Test
    public void should_return_specified_double() throws Exception {
        Args args = new Args("d##", new String[]{"-d", "123.5"});
        assertThat(args.<Double>getValue("d")).isEqualTo(123.5);
    }

    @Test
    public void should_return_false_not_exist_boolean_value() throws Exception {
        Args args = new Args("l", new String[]{"-l"});
        assertThat(args.<Boolean>getValue("l")).isFalse();
    }

    @Test
    public void should_return_true_when_existed_boolean_value() throws Exception {
        Args args = new Args("l", new String[]{"-l", "1"});
        assertThat(args.<Boolean>getValue("l")).isTrue();
    }

    @Test
    public void should_return_default_empty_string_arrays() throws Exception {
        Args args = new Args("s[*]", new String[]{"-s"});
        assertThat(args.<String[]>getValue("s")).isEmpty();
    }

    @Test
    public void should_return_specified_string_arrays() throws Exception {
        Args args = new Args("s[*]", new String[]{"-s", "This is args"});
        String[] values = args.getValue("s");
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo("This");
        assertThat(values[1]).isEqualTo("is");
        assertThat(values[2]).isEqualTo("args");
    }

    @Test
    public void should_return_default_empty_int_arrays() throws Exception {
        Args args = new Args("i[#]", new String[]{"-i"});
        assertThat(args.<Integer[]>getValue("i")).isEmpty();
    }

    @Test
    public void should_return_specified_int_arrays() throws Exception {
        Args args = new Args("i[#]", new String[]{"-i", "0 1 -2"});
        Integer[] values = args.getValue("i");
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo(0);
        assertThat(values[1]).isEqualTo(1);
        assertThat(values[2]).isEqualTo(-2);
    }

    @Test
    public void should_return_default_empty_double_arrays() throws Exception {
        Args args = new Args("d[##]", new String[]{"-d"});
        assertThat(args.<Double[]>getValue("d")).isEmpty();
    }

    @Test
    public void should_return_specified_double_arrays() throws Exception {
        Args args = new Args("d[##]", new String[]{"-d", "0 1.5 -2.5"});
        Double[] values = args.getValue("d");
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo(0.0);
        assertThat(values[1]).isEqualTo(1.5);
        assertThat(values[2]).isEqualTo(-2.5);
    }

    @Test
    public void should_return_default_empty_map() throws Exception {
        Args args = new Args("m[&&]", new String[]{"-m"});
        assertThat(args.<Map<String, String>>getValue("m")).isEmpty();
    }

    @Test
    public void should_return_specified_map() throws Exception {
        Args args = new Args("m[&&]", new String[]{"-m", "name:lyning,age:25"});
        Map<String, String> values = args.getValue("m");
        assertThat(values).isNotEmpty();
        assertThat(values.size()).isEqualTo(2);
        assertThat(values.get("name")).isEqualTo("lyning");
        assertThat(values.get("age")).isEqualTo("25");
    }

    @Test
    public void should_return_default_empty_set() throws Exception {
        Args args = new Args("s[&]", new String[]{"-s"});
        assertThat(args.<Set<String>>getValue("s")).isEmpty();
    }

    @Test
    public void should_return_specified_set() throws Exception {
        Args args = new Args("s[&]", new String[]{"-s", "a a b b c c"});
        Set<String> values = args.getValue("s");
        assertThat(values).isNotEmpty();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.contains("a")).isTrue();
        assertThat(values.contains("b")).isTrue();
        assertThat(values.contains("c")).isTrue();
    }

    @Test
    public void multiple_flag() {
        Args args = new Args("a*,b#,c##,d[*],e[#],f[##],g[&],h[&&],", new String[]{
                "-a", "你好",
                "-b", "10",
                "-c", "3.14",
                "-d", "你 好 呀",
                "-e", "1 2 3",
                "-f", "1.0 2.0 3.5",
                "-g", "a b c c",
                "-h", "name:lyning,age:25",
        });
        assertThat(args.<String>getValue("a")).isEqualTo("你好");
        assertThat(args.<Integer>getValue("b")).isEqualTo(10);
        assertThat(args.<Double>getValue("c")).isEqualTo(3.14);

        String[] stringArr = args.getValue("d");
        assertThat(stringArr.length).isEqualTo(3);
        assertThat(stringArr[0]).isEqualTo("你");
        assertThat(stringArr[1]).isEqualTo("好");
        assertThat(stringArr[2]).isEqualTo("呀");

        Integer[] intArr = args.getValue("e");
        assertThat(intArr.length).isEqualTo(3);
        assertThat(intArr[0]).isEqualTo(1);
        assertThat(intArr[1]).isEqualTo(2);
        assertThat(intArr[2]).isEqualTo(3);

        Double[] doubleArr = args.getValue("f");
        assertThat(doubleArr.length).isEqualTo(3);
        assertThat(doubleArr[0]).isEqualTo(1.0);
        assertThat(doubleArr[1]).isEqualTo(2.0);
        assertThat(doubleArr[2]).isEqualTo(3.5);

        Set<String> set = args.getValue("g");
        assertThat(set.size()).isEqualTo(3);
        assertThat(set.contains("a")).isTrue();
        assertThat(set.contains("b")).isTrue();
        assertThat(set.contains("c")).isTrue();

        Map<String, String> map = args.getValue("h");
        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get("name")).isEqualTo("lyning");
        assertThat(map.get("age")).isEqualTo("25");
    }
}
