package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.List;
import java.util.Objects;

/**
 * @author lyning
 */
public class GalaxyGuide {

    private SymbolCalculator symbolCalculator = new SymbolCalculator();

    public void receiveConvert(String text) {
        InputHandler inputHandler = new InputHandler();
        inputHandler.convert(text);
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
                        avgCredits = inputHandler.getMetalsToAvgCreditsMap().get(word);
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
                System.out.println(questionArr[1].replace("?", "is ") + credits.intValue() + (isContainCreditsWord ? " Credits" : ""));
            } catch (Exception e) {
                System.out.println("I have no idea what you are talking about");
            }
        }
    }
}
