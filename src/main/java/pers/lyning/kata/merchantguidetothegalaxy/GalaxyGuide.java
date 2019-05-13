package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.*;

/**
 * @author lyning
 */
public class GalaxyGuide {

    private final InputHandler inputHandler = new InputHandler();
    private final Map<String, Double> metalsToAvgCreditsMap = new HashMap<>();
    private final SymbolCalculator symbolCalculator = new SymbolCalculator();

    public void display() {
        List<String> answers = this.answer();
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    public void receive(String multipleLineText) throws Exception {
        this.inputHandler.handle(multipleLineText);
        this.calcAvgCreditsOfMetals();
    }

    private List<String> answer() {
        List<String> answers = new ArrayList<>();
        List<String> questions = this.inputHandler.getQuestions();
        for (String question : questions) {
            try {
                boolean isContainCreditsWord = question.contains("Credits");
                String[] questionArr = question.split(" is ");
                String[] wordArr = questionArr[1].replace("?", "").split(" ");
                String symbols = "";
                Double avgCredits = null;
                for (String word : wordArr) {
                    String symbol = this.inputHandler.getWordToSymbolMap()
                            .get(word);
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
                    symbols += this.inputHandler.getWordToSymbolMap()
                            .get(leftArr[i]);
                }
                double number = this.symbolCalculator.calc(symbols);
                double credits = Integer.valueOf(rightArr[0]);
                double avg = credits / number;
                String metals = leftArr[leftArr.length - 1];
                this.metalsToAvgCreditsMap.put(metals, avg);
            }
        }
    }
}
