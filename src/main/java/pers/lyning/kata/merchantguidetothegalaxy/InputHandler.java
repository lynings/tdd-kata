package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.*;

/**
 * @author lyning
 */
public class InputHandler {

    private List<String> questions = new ArrayList<>();
    private Map<String, String> wordToSymbolMap = new HashMap<>();
    private Map<String, Double> metalsToAvgCreditsMap = new HashMap<>();
    private String[] textLines = null;

    public void convert(String multipleLineText) throws Exception {
        textLines = multipleLineText.split("\\n\\n|\\n");
        this.convertIfWordToSymbol();
        this.convertIfMetalsToCredits();
        this.convertIfQuestion();
    }

    private void convertIfQuestion() {
        for (String text : textLines) {
            if (text.startsWith("how") && text.endsWith("?")) {
                this.questions.add(text);
            }
        }
    }

    private void convertIfMetalsToCredits() throws Exception {
        SymbolCalculator symbolCalculator = new SymbolCalculator();
        for (String line : textLines) {
            if (line.endsWith("Credits")) {
                String[] arr = line.split(" is ");
                String[] leftArr = arr[0].split(" ");
                String[] rightArr = arr[1].split(" ");
                String symbols = "";
                for (int i = 0; i < leftArr.length - 1; i++) {
                    symbols += this.wordToSymbolMap.get(leftArr[i]);
                }
                double number = symbolCalculator.calc(symbols);
                double credits = Integer.valueOf(rightArr[0]);
                double avg = credits / number;
                String metals = leftArr[leftArr.length - 1];
                this.metalsToAvgCreditsMap.put(metals, avg);
            }
        }
    }

    private void convertIfWordToSymbol() {
        for (String line : textLines) {
            String symbol = this.getLastWord(line);
            if (!Objects.isNull(SymbolTable.getValue(symbol))) {
                this.wordToSymbolMap.put(line.split(" is ")[0], symbol);
            }
        }
    }

    private String getLastWord(String line) {
        return line.split(" ")[line.split(" ").length - 1];
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
