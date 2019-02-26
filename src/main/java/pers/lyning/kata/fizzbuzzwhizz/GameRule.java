package pers.lyning.kata.fizzbuzzwhizz;

public class GameRule {
    private Integer number;
    private String term;

    public GameRule(Integer number, String term) {
        this.number = number;
        this.term = term;
    }

    public Integer getNumber() {
        return number;
    }

    public String getTerm() {
        return term;
    }
}
