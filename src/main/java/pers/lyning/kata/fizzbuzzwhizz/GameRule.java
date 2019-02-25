package pers.lyning.kata.fizzbuzzwhizz;

public class GameRule {
    private Integer random;
    private String term;

    public GameRule(Integer random, String term) {
        this.random = random;
        this.term = term;
    }

    public Integer getRandom() {
        return random;
    }

    public String getTerm() {
        return term;
    }
}
