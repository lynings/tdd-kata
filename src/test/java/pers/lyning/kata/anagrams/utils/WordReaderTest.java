package pers.lyning.kata.anagrams.utils;

import org.junit.Test;
import pers.lyning.kata.anagrams.Word;
import pers.lyning.kata.testing.TestResourceFinder;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WordReaderTest {

    @Test
    public void should_read_1633_words() throws IOException {
        // given
        File wordFile = TestResourceFinder.getFile("/anagrams/wordlist_1633.txt");
        // when
        Set<Word> words = WordReader.from(wordFile)
                .asWords();
        // then
        assertThat(words.size()).isEqualTo(1633);
    }

    @Test
    public void should_read_338882_words() throws IOException {
        // given
        File wordFile = TestResourceFinder.getFile("/anagrams/wordlist_338882.txt");
        // when
        Set<Word> words = WordReader.from(wordFile)
                .asWords();
        // then
        assertThat(words.size()).isEqualTo(338882);
    }
}