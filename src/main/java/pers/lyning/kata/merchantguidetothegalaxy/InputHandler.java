package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.*;

/**
 * @author lyning
 */
public class InputHandler {

    private List<String> questions = new ArrayList<>();
    private Map<String, String> wordToSymbolMap = new HashMap<>();
    private List<String> metalsCreditsLineList = new ArrayList<>();
    private String[] textLines = null;

    public void handle(String multipleLineText) throws Exception {
        textLines = multipleLineText.split("\\n\\n|\\n");
        this.convertIfWordToSymbol();
        this.assembleMetalsCreditsText();
        this.assembleQuestion();
    }

    private void assembleQuestion() {
        for (String text : textLines) {
            if (text.endsWith("?")) {
                this.questions.add(text);
            }
        }
    }

    private void assembleMetalsCreditsText() throws Exception {
        for (String line : textLines) {
            if (line.endsWith("Credits")) {
                metalsCreditsLineList.add(line);
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

    public List<String> getMetalsCreditsLineList() {
        return metalsCreditsLineList;
    }
}
