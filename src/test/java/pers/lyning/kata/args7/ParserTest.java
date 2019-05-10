package pers.lyning.kata.args7;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lyning
 */
public class ParserTest {

//    @Test
    public void should_return_false() {
        // given
        Parser parser = new Parser("l", new String[] {"-l"});
        // when
        boolean value = parser.getValue("l");
        // then
        assertThat(value).isFalse();
    }

//    @Test
    public void should_return_true() {
        // given
        Parser parser = new Parser("l", new String[] {"-l 1"});
        // when
        boolean value = parser.getValue("l");
        // then
        assertThat(value).isTrue();
    }
}
