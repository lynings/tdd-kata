package pers.lyning.kata.args6;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author lyning
 */
public class SchemaTest {

    @Test
    public void parse_no_schemas() {
        Schema schema = Schema.parse("");
        Assertions.assertThat(schema.size()).isEqualTo(0);
    }

    @Test
    public void parse_one_flag() {
        Schema schema = Schema.parse("l");
        Assertions.assertThat(schema.size()).isEqualTo(1);
        Assertions.assertThat(schema.get("l")).isEqualTo("");
    }

    @Test
    public void parse_one_schema() {
        Schema schema = Schema.parse("s*");
        Assertions.assertThat(schema.size()).isEqualTo(1);
        Assertions.assertThat(schema.get("s")).isEqualTo("*");
    }

    @Test
    public void parse_multiple_schemas() {
        Schema schema = Schema.parse("s*,d#,r[*]");
        Assertions.assertThat(schema.size()).isEqualTo(3);
        Assertions.assertThat(schema.get("s")).isEqualTo("*");
        Assertions.assertThat(schema.get("d")).isEqualTo("#");
        Assertions.assertThat(schema.get("r")).isEqualTo("[*]");
    }
}
