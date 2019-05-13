package pers.lyning.kata.anagrams;

import org.junit.Test;
import pers.lyning.kata.anagrams.utils.WordReader;
import pers.lyning.kata.testing.TestResourceFinder;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WordArrangerTest {

    @Test
    public void arrange() {
        // given
        Set<Word> words = Words.asSet("kinship", "pinkish");
        // when
        List<Set<Word>> wordsGroup = WordArranger.arrange(words);
        // then
        assertThat(wordsGroup.size()).isEqualTo(1);
        assertThat(this.countWords(wordsGroup)).isEqualTo(words.size());
    }

    private long countWords(List<Set<Word>> wordsGroup) {
        return wordsGroup.stream()
                .flatMap(Collection::stream)
                .count();
    }

    @Test
    public void arrange_10_word_list() {
        // given
        Set<Word> words = Words.asSet(
                "kinship", "pinkish",
                "abc", "acb", "bca", "bac", "cab", "cba",
                "lyning", "ningly"
        );
        // when
        List<Set<Word>> wordsGroup = WordArranger.arrange(words);
        // then
        assertThat(wordsGroup.size()).isEqualTo(3);
        assertThat(this.countWords(wordsGroup)).isEqualTo(words.size());
    }

    @Test
    public void arrange_1633_word_list() throws IOException {
        // given
        File wordFile = TestResourceFinder.getFile("/anagrams/wordlist_1633.txt");
        Set<Word> words = WordReader.from(wordFile).asWords();
        // when
        List<Set<Word>> wordsGroup = WordArranger.arrange(words);
        // then
        assertThat(wordsGroup.size()).isEqualTo(1609);
        assertThat(this.countWords(wordsGroup)).isEqualTo(words.size());
    }
}