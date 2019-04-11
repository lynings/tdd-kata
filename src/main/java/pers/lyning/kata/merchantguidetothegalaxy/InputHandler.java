package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lyning
 */
public class InputConverter {

    private List<String> questions = new ArrayList<>();
    private Map<String, String> wordToSymbolMap = new HashMap<>();
    private Map<String, Double> metalsToAvgCreditsMap = new HashMap<>();
    private String[] textArr = null;

    public void convert(String text) {
        textArr = text.split("\\n\\n|\\n");
        this.convertIfWordToSymbol();
        this.convertIfMetalsToCredits();
        this.convertIfQuestion();
    }

    private void convertIfQuestion() {
        for (String text : textArr) {
            if (text.startsWith("how") && text.endsWith("?")) {
                this.questions.add(text);
            }
        }
    }

    private void convertIfMetalsToCredits() {
        SymbolCalculator symbolCalculator = new SymbolCalculator();
        for (String text : textArr) {
            if (text.endsWith("Credits")) {
                String[] arr = text.split(" is ");
                String[] leftArr = arr[0].split(" ");
                String[] rightArr = arr[1].split(" ");
                String symbols = "";
                for (int i = 0; i < leftArr.length - 1; i++) {
                    symbols += this.wordToSymbolMap.get(leftArr[i]);
                }
                int number = symbolCalculator.calc(symbols);
                int credits = Integer.valueOf(rightArr[0]);
                double avg = credits / number;
                String metals = leftArr[leftArr.length - 1];
                this.metalsToAvgCreditsMap.put(metals, avg);
            }
        }
    }

    private void convertIfWordToSymbol() {
        for (String text : textArr) {
            for (String symbol : SymbolConverter.table.keySet()) {
                if (text.endsWith(symbol)) {
                    this.wordToSymbolMap.put(text.split(" is ")[0], symbol);
                    break;
                }
            }
        }
    }

    public List<String> getQuestions() {
        return questions;
    }

    public Map<String, String> getWordToSymbolMap() {
        return wordToSymbolMap;
    }

    public Map<String, Double> getMetalsToAvgCreditsMap() {
        return metalsToAvgCreditsMap;
    }
}
