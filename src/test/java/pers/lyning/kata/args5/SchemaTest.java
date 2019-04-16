package pers.lyning.kata.args5;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class SchemaTest {

    @Test
    public void parse_no_schema() {
        Schema schema = Schema.parse("");
        assertThat(schema.size()).isEqualTo(0);
        assertThat(schema.get("l")).isNull();
    }

    @Test
    public void parse_one_schema() {
        Schema schema = Schema.parse("l");
        assertThat(schema.size()).isEqualTo(1);
        assertThat(schema.get("l")).isEqualTo("");
    }

    @Test
    public void parse_multiple_schemas() {
        Schema schema = Schema.parse("l,s*,i#,r[*]");
        assertThat(schema.size()).isEqualTo(4);
        assertThat(schema.get("l")).isEqualTo("");
        assertThat(schema.get("s")).isEqualTo("*");
        assertThat(schema.get("i")).isEqualTo("#");
        assertThat(schema.get("r")).isEqualTo("[*]");
    }
}
