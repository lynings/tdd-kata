package pers.lyning.kata.merchantguidetothegalaxy;

import java.util.*;

/**
 * @author lyning
 */
public class InputHandler {

    private final List<String> metalsCreditsLineList = new ArrayList<>();
    private final List<String> questions = new ArrayList<>();
    private final Map<String, String> wordToSymbolMap = new HashMap<>();
    private String[] textLines = null;

    public List<String> getMetalsCreditsLineList() {
        return this.metalsCreditsLineList;
    }

    public List<String> getQuestions() {
        return this.questions;
    }

    public Map<String, String> getWordToSymbolMap() {
        return this.wordToSymbolMap;
    }

    public void handle(String multipleLineText) throws Exception {
        this.textLines = multipleLineText.split("\\n\\n|\\n");
        this.convertIfWordToSymbol();
        this.assembleMetalsCreditsText();
        this.assembleQuestion();
    }

    private void assembleMetalsCreditsText() throws Exception {
        for (String line : this.textLines) {
            if (line.endsWith("Credits")) {
                this.metalsCreditsLineList.add(line);
            }
        }
    }

    private void assembleQuestion() {
        for (String text : this.textLines) {
            if (text.endsWith("?")) {
                this.questions.add(text);
            }
        }
    }

    private void convertIfWordToSymbol() {
        for (String line : this.textLines) {
            String symbol = this.getLastWord(line);
            if (!Objects.isNull(SymbolTable.getValue(symbol))) {
                this.wordToSymbolMap.put(line.split(" is ")[0], symbol);
            }
        }
    }

    private String getLastWord(String line) {
        return line.split(" ")[line.split(" ").length - 1];
    }
}
