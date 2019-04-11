package pers.lyning.kata.merchantguidetothegalaxy.validator;

import pers.lyning.kata.merchantguidetothegalaxy.SymbolTable;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class RepeatedThreeTimesConstraintValidator implements SymbolsConstraintValidator {

    private final List<String> SYMBOLS = Arrays.asList("I", "X", "C", "M");

    @Override
    public boolean validate(String symbols) {
        for (String symbol : SYMBOLS) {
            Integer repeatTimes = this.calcRepeatTimes(symbols, symbol);
            if (repeatTimes > 4) {
                return false;
            }

            if (repeatTimes == 4) {
                int lastSymbolIndex = symbols.lastIndexOf(symbol);
                String[] symbolsArr = symbols.split("");
                if (!this.isLessThan(symbolsArr[lastSymbolIndex - 1], symbol)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Integer calcRepeatTimes(String source, String target) {
        return source.length() - source.replace(target, "").length();
    }

    private boolean isLessThan(String source, String target) {
        return SymbolTable.getValue(source) < SymbolTable.getValue(target);
    }
}
