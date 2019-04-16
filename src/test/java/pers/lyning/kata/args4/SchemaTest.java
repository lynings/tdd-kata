package pers.lyning.kata.args4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class SchemaTest {

    @Test
    public void parse_one_schema() {
        Schema schema = Schema.parse("i#");
        assertThat(schema.has("#"));
        assertThat(schema.hasFlag("i"));
        assertThat(schema.get("i")).isEqualTo("#");
        assertThat(schema.size()).isEqualTo(1);
    }

    @Test
    public void parse_multiple_schema() {
        Schema schema = Schema.parse("i#,s*,l");
        assertThat(schema.has("#")).isTrue();
        assertThat(schema.has("*")).isTrue();
        assertThat(schema.has("")).isTrue();

        assertThat(schema.hasFlag("i")).isTrue();
        assertThat(schema.hasFlag("s")).isTrue();
        assertThat(schema.hasFlag("l")).isTrue();

        assertThat(schema.get("i")).isEqualTo("#");
        assertThat(schema.get("s")).isEqualTo("*");
        assertThat(schema.get("l")).isEqualTo("");

        assertThat(schema.size()).isEqualTo(3);
    }
}
