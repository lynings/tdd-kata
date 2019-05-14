package pers.lyning.kata.args;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pers.lyning.kata.args.exception.ArgsException;
import pers.lyning.kata.args.factory.ValueParserFactory;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ArgsTest {

    @Rule
    public final ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = ArgsException.class)
    public void should_fail_when_flag_not_found() {
        // given
        Args args = new Args("s*", new String[]{"-s", "a"});
        // when
        String value = args.getValue('a');
        // then
        assertThat(value).isEqualTo("");
    }

    @Test(expected = ArgsException.class)
    public void should_fail_when_schema_not_implemented() {
        // given
        Args args = new Args("s^^^", new String[]{"-s", "test"});
        // when
        args.getValue('s');
        // then throw a Exception
    }

    @Test
    public void should_return_empty_string() throws Exception {
        // given
        Args args = new Args("s*", new String[]{"-s"});
        // when
        String value = args.<String>getValue('s');
        // then
        assertThat(value).isEqualTo("");
    }

    @Test
    public void should_return_string_value() throws Exception {
        // given
        Args args = new Args("s*", new String[]{"-s", "a"});
        // when
        String value = args.getValue('s');
        // then
        assertThat(value).isEqualTo("a");
    }

    @Test
    public void should_fail_when_input_incorrect_integer_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an integer，such as -i 1");
        // given
        Args args = new Args("i#", new String[]{"-i", "a"});
        // when
        args.<Integer>getValue('i');
        // then throw a exception
    }

    @Test
    public void should_return_default_integer_value() throws Exception {
        // given
        Args args = new Args("i#", new String[]{"-i"});
        // when
        Integer value = args.<Integer>getValue('i');
        // then
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void should_return_integer_value() throws Exception {
        // given
        Args args = new Args("i#", new String[]{"-i", "123"});
        // when
        Integer value = args.<Integer>getValue('i');
        // then
        assertThat(value).isEqualTo(123);
    }

    @Test
    public void should_return_default_double_value() throws Exception {
        // given
        Args args = new Args("d##", new String[]{"-d"});
        // when
        Double value = args.<Double>getValue('d');
        // then
        assertThat(value).isEqualTo(0.0);
    }

    @Test
    public void should_fail_when_input_incorrect_double_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an double，such as -d 2.5");
        // given
        Args args = new Args("d##", new String[]{"-d", "a"});
        // when
        args.<Integer>getValue('d');
        // when throw a exception
    }

    @Test
    public void should_return_double_value() throws Exception {
        // given
        Args args = new Args("d##", new String[]{"-d", "123.5"});
        // when
        Double value = args.getValue('d');
        // given
        assertThat(value).isEqualTo(123.5);
    }

    @Test
    public void should_return_false() throws Exception {
        // given
        Args args = new Args("l", new String[]{"-l"});
        // when
        Boolean value = args.getValue('l');
        // then
        assertThat(value).isFalse();
    }

    @Test
    public void should_return_true() throws Exception {
        // given
        Args args = new Args("l", new String[]{"-l", "1"});
        // when
        Boolean value = args.<Boolean>getValue('l');
        // then
        assertThat(value).isTrue();
    }

    @Test
    public void should_return_empty_string_arrays() throws Exception {
        // given
        Args args = new Args("s[*]", new String[]{"-s"});
        // when
        String[] value = args.getValue('s');
        // then
        assertThat(value).isEmpty();
    }

    @Test
    public void should_return_string_arrays() throws Exception {
        // given
        Args args = new Args("s[*]", new String[]{"-s", "This is args"});
        // when
        String[] values = args.getValue('s');
        // then
        assertThat(values).isNotEmpty();
        assertThat(values.length).isEqualTo(3);
        assertThat(values[0]).isEqualTo("This");
        assertThat(values[1]).isEqualTo("is");
        assertThat(values[2]).isEqualTo("args");
    }

    @Test
    public void should_return_empty_int_arrays() throws Exception {
        // given
        Args args = new Args("i[#]", new String[]{"-i"});
        // when
        Integer[] value = args.getValue('i');
        // then
        assertThat(value).isEmpty();
    }

    @Test
    public void should_return_int_arrays() throws Exception {
        // given
        Args args = new Args("i[#]", new String[]{"-i", "0 1 -2"});
        // when
        Integer[] values = args.getValue('i');
        // then
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
        // given
        Args args = new Args("i[#]", new String[]{"-i", "0 1 2 a"});
        // then
        args.<Integer>getValue('i');
        // then throw a exception
    }

    @Test
    public void should_return_empty_double_arrays() throws Exception {
        // given
        Args args = new Args("d[##]", new String[]{"-d"});
        // when
        Double[] value = args.getValue('d');
        // then
        assertThat(value).isEmpty();
    }

    @Test
    public void should_return_double_arrays() throws Exception {
        // given
        Args args = new Args("d[##]", new String[]{"-d", "0 1.5 -2.5"});
        // when
        Double[] values = args.getValue('d');
        // then
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
        // given
        Args args = new Args("d[##]", new String[]{"-d", "1.0 2.5 3.14 a"});
        // when
        args.<Integer>getValue('d');
        // then throw a exception
    }

    @Test
    public void should_return_empty_map() throws Exception {
        // given
        Args args = new Args("m[&&]", new String[]{"-m"});
        // when
        Map<String, String> value = args.getValue('m');
        // given
        assertThat(value).isEmpty();
    }

    @Test
    public void should_return_map() throws Exception {
        // given
        Args args = new Args("m[&&]", new String[]{"-m", "name:lyning,age:25"});
        // when
        Map<String, String> values = args.getValue('m');
        // then
        assertThat(values.size()).isEqualTo(2);
        assertThat(values.get("name")).isEqualTo("lyning");
        assertThat(values.get("age")).isEqualTo("25");
    }

    @Test
    public void should_fail_when_input_incorrect_map_value() throws Exception {
        expectedEx.expect(ArgsException.class);
        expectedEx.expectMessage("The value of args must be an map，such as -m[&&] key1:val1,key2:val2,...");
        // given
        Args args = new Args("m[&&]", new String[]{"-m", "name:lyning,age"});
        // when
        args.<Integer>getValue('m');
        // then throw a exception
    }

    @Test
    public void should_return_empty_set() throws Exception {
        // given
        Args args = new Args("s[&]", new String[]{"-s"});
        // when
        Set<String> value = args.getValue('s');
        // then
        assertThat(value).isEmpty();
    }

    @Test
    public void should_return_set() throws Exception {
        // given
        Args args = new Args("s[&]", new String[]{"-s", "a a b b c c"});
        // when
        Set<String> values = args.getValue('s');
        // then
        assertThat(values).isNotEmpty();
        assertThat(values.size()).isEqualTo(3);
        assertThat(values.contains("a")).isTrue();
        assertThat(values.contains("b")).isTrue();
        assertThat(values.contains("c")).isTrue();
    }

    @Test
    public void multiple_schemas() {
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
        assertThat(args.<String>getValue('a')).isEqualTo("你好");
        assertThat(args.<Integer>getValue('b')).isEqualTo(10);
        assertThat(args.<Double>getValue('c')).isEqualTo(3.14);

        String[] stringArr = args.getValue('d');
        assertThat(stringArr.length).isEqualTo(3);
        assertThat(stringArr[0]).isEqualTo("你");
        assertThat(stringArr[1]).isEqualTo("好");
        assertThat(stringArr[2]).isEqualTo("呀");

        Integer[] intArr = args.getValue('e');
        assertThat(intArr.length).isEqualTo(3);
        assertThat(intArr[0]).isEqualTo(1);
        assertThat(intArr[1]).isEqualTo(2);
        assertThat(intArr[2]).isEqualTo(3);

        Double[] doubleArr = args.getValue('f');
        assertThat(doubleArr.length).isEqualTo(3);
        assertThat(doubleArr[0]).isEqualTo(1.0);
        assertThat(doubleArr[1]).isEqualTo(2.0);
        assertThat(doubleArr[2]).isEqualTo(3.5);

        Set<String> set = args.getValue('g');
        assertThat(set.size()).isEqualTo(3);
        assertThat(set.contains("a")).isTrue();
        assertThat(set.contains("b")).isTrue();
        assertThat(set.contains("c")).isTrue();

        Map<String, String> map = args.getValue('h');
        assertThat(map.size()).isEqualTo(2);
        assertThat(map.get("name")).isEqualTo("lyning");
        assertThat(map.get("age")).isEqualTo("25");
    }

    @Test
    public void should_return_string_array_schema_description() {
        // given
        Args args = new Args("h[help]", new String[]{"-h", "[*]"});
        // when
        Map<String, String> schemaToDescriptionMap = args.getValue('h');
        // then
        assertThat(schemaToDescriptionMap.size()).isEqualTo(1);
        assertThat(schemaToDescriptionMap.get("[*]")).isEqualTo(ValueParserFactory.getInstance("[*]").getDescription());
    }

    @Test
    public void should_return_multiple_schema_description() {
        // given
        Args args = new Args("h[help]", new String[]{"-h", "[&] [#] [help]"});
        // when
        Map<String, String> schemaToDescriptionMap = args.getValue('h');
        // then
        assertThat(schemaToDescriptionMap.size()).isEqualTo(3);
        assertThat(schemaToDescriptionMap.get("[&]")).isEqualTo(ValueParserFactory.getInstance("[&]").getDescription());
        assertThat(schemaToDescriptionMap.get("[#]")).isEqualTo(ValueParserFactory.getInstance("[#]").getDescription());
        assertThat(schemaToDescriptionMap.get("[help]")).isEqualTo(ValueParserFactory.getInstance("[help]").getDescription());
    }

    @Test
    public void should_return_all_schema_description() {
        // given
        Args args = new Args("h[help]", new String[]{"-h"});
        // when
        Map<String, String> schemaToDescriptionMap = args.getValue('h');
        // then
        assertThat(schemaToDescriptionMap.size()).isEqualTo(10);
        for (Map.Entry<String, String> entry : schemaToDescriptionMap.entrySet()) {
            assertThat(entry.getValue()).isEqualTo(ValueParserFactory.getInstance(entry.getKey()).getDescription());
        }
    }
}
