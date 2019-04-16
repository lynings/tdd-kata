package pers.lyning.kata.args3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class SchemaTest {

    /*********** has test start *********/
    @Test
    public void has_schema_when_parse_one_schema() {
        Schema schema = Schema.parse("i#");
        assertThat(schema.has("#")).isTrue();
        assertThat(schema.has("i")).isFalse();
    }

    @Test
    public void has_schema_when_parse_two_schema() {
        Schema schema = Schema.parse("s*,i#");
        assertThat(schema.has("#")).isTrue();
        assertThat(schema.has("*")).isTrue();
        assertThat(schema.has("s")).isFalse();
        assertThat(schema.has("i")).isFalse();
    }
    /*********** has test end *********/


    /*********** hasFlag test start *********/
    @Test
    public void has_flag_when_parse_one_schema() {
        Schema schema = Schema.parse("i#");
        assertThat(schema.hasFlag("i")).isTrue();
        assertThat(schema.hasFlag("#")).isFalse();
    }

    @Test
    public void has_flag_when_parse_two_schema() {
        Schema schema = Schema.parse("i#,s*");
        assertThat(schema.hasFlag("s")).isTrue();
        assertThat(schema.hasFlag("i")).isTrue();
        assertThat(schema.hasFlag("#")).isFalse();
        assertThat(schema.hasFlag("*")).isFalse();
    }
    /*********** hasFlag test end *********/


    /*********** get test start *********/
    @Test
    public void get_schema() {
        Schema schema = Schema.parse("i#,s*");
        assertThat(schema.get("i")).isEqualTo("#");
        assertThat(schema.get("s")).isEqualTo("*");
    }
    /*********** get test end *********/
}
