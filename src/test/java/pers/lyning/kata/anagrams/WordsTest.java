package pers.lyning.kata.anagrams;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class WordsTest {

    /********** parse test start **********/
    @Test
    public void parse() throws Exception {
        File file = new File(WordsTest.class.getResource("/anagrams/wordlist_1633.txt").getPath());
        Words words = WordReader.from(file).asWords();
        assertThat(words).isNotNull();
        assertThat(words.size()).isEqualTo(1633);
    }
    /********** parse test end **********/


    /********** contains test start **********/
    @Test
    public void contains() throws Exception {
        Words words = Words.of("acrobat");
        assertThat(words).isNotNull();
        assertThat(words.contains("acrobat")).isTrue();
        assertThat(words.contains("lyning")).isFalse();
    }
    /********** contains test end **********/


    /********** size test start **********/
    @Test
    public void size() {
        Words words = Words.of("acrobat", "lyning", "lyning");
        assertThat(words).isNotNull();
        assertThat(words.size()).isEqualTo(words.size());
    }
    /********** size test end **********/
}