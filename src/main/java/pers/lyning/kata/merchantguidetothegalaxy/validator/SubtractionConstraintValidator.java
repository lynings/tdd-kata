package pers.lyning.kata.merchantguidetothegalaxy.validator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lyning
 */
public class SubtractionConstraintValidator implements SymbolsConstraintValidator {

    private final Set<String> CANNOT_SUBTRACTED_SYMBOLS = new HashSet() {{
        this.add("V");
        this.add("L");
        this.add("D");
    }};
    private final int SYMBOL_LENGTH = 2;
    private final Map<String, Set<String>> symbolToCanSubtractedSymbolMap = new HashMap() {{
        this.put("I", new HashSet() {{
            this.add("V");
            this.add("X");
        }});
        this.put("C", new HashSet() {{
            this.add("D");
            this.add("M");
        }});
        this.put("X", new HashSet() {{
            this.add("L");
            this.add("C");
        }});
    }};

    @Override
    public boolean validate(String symbols) {
        String[] symbolsArr = symbols.split("");
        if (symbolsArr.length != this.SYMBOL_LENGTH) {
            return false;
        }
        String subtractedSymbol = symbolsArr[0];
        String symbol = symbolsArr[1];
        return !this.CANNOT_SUBTRACTED_SYMBOLS.contains(subtractedSymbol)
                && this.symbolToCanSubtractedSymbolMap.containsKey(subtractedSymbol)
                && this.symbolToCanSubtractedSymbolMap.get(subtractedSymbol)
                .contains(symbol);
    }
}
