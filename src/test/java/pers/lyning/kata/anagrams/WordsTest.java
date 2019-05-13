package pers.lyning.kata.anagrams;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class WordsTest {

    @Test
    public void non_repetitive_words() throws Exception {
        File file = new File(WordsTest.class.getResource("/anagrams/wordlist_1633.txt").getPath());
        Words words = WordReader.from(file).asWords();
        assertThat(words.size()).isEqualTo(1633);
    }

    @Test
    public void repetitive_words() throws Exception {
        Words words = Words.of("lyning", "lyning");
        assertThat(words.size()).isEqualTo(1);
    }
}