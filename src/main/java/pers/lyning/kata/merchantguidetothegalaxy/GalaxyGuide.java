package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.*;

/**
 * @author lyning
 */
public class GalaxyGuide {

    private SymbolCalculator symbolCalculator = new SymbolCalculator();
    private InputHandler inputHandler = new InputHandler();
    private Map<String, Double> metalsToAvgCreditsMap = new HashMap<>();

    public void receive(String multipleLineText) throws Exception {
        inputHandler.handle(multipleLineText);
        this.calcAvgCreditsOfMetals();
    }

    public void display() {
        List<String> answers = this.answer();
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    private List<String> answer() {
        List<String> answers = new ArrayList<>();
        List<String> questions = inputHandler.getQuestions();
        for (String question : questions) {
            try {
                boolean isContainCreditsWord = question.contains("Credits");
                String[] questionArr = question.split(" is ");
                String[] wordArr = questionArr[1].replace("?", "").split(" ");
                String symbols = "";
                Double avgCredits = null;
                for (String word : wordArr) {
                    String symbol = inputHandler.getWordToSymbolMap().get(word);
                    if (Objects.isNull(symbol)) {
                        avgCredits = this.metalsToAvgCreditsMap.get(word);
                    } else {
                        symbols += symbol;
                    }
                }
                Double credits;
                if (Objects.isNull(avgCredits)) {
                    credits = this.symbolCalculator.calc(symbols) + 0.0;
                } else {
                    credits = this.symbolCalculator.calc(symbols) * avgCredits;
                }
                answers.add(questionArr[1].replace("?", "is ") + credits.intValue() + (isContainCreditsWord ? " Credits" : ""));
            } catch (Exception e) {
                answers.add("I have no idea what you are talking about");
            }
        }
        return answers;
    }

    private void calcAvgCreditsOfMetals() throws Exception {
        List<String> metalsCreditsLineList = this.inputHandler.getMetalsCreditsLineList();
        for (String line : metalsCreditsLineList) {
            if (line.endsWith("Credits")) {
                String[] arr = line.split(" is ");
                String[] leftArr = arr[0].split(" ");
                String[] rightArr = arr[1].split(" ");
                String symbols = "";
                for (int i = 0; i < leftArr.length - 1; i++) {
                    symbols += this.inputHandler.getWordToSymbolMap().get(leftArr[i]);
                }
                double number = symbolCalculator.calc(symbols);
                double credits = Integer.valueOf(rightArr[0]);
                double avg = credits / number;
                String metals = leftArr[leftArr.length - 1];
                this.metalsToAvgCreditsMap.put(metals, avg);
            }
        }
    }
}
