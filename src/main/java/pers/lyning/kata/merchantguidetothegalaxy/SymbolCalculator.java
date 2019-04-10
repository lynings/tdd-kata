package pers.lyning.kata.merchantguidetothegalaxy;

/**
 * @author lyning
 */
public class SymbolCalculator {

    private SymbolConverter symbolConverter = new SymbolConverter();

    public Integer calc(String symbols) {
        String[] symbolsArr = symbols.split("");
        Integer result = 0;
        for (int index = 1, len = symbolsArr.length; index < len; index++) {
            if (this.greaterThanOrEqualTo(symbolsArr[index - 1], symbolsArr[index])) {
                if ((index + 1) < len) {
                    if (this.greaterThanOrEqualTo(symbolsArr[index], symbolsArr[index + 1])) {
                        result += this.add(symbolsArr[index - 1], symbolsArr[index]);
                        index += 1;
                    } else {
                        result += this.symbolConverter.convert(symbolsArr[index - 1]);
                    }
                } else {
                    result += this.add(symbolsArr[index - 1], symbolsArr[index]);
                    index += 1;
                }
            } else {
                result += this.subtract(symbolsArr[index], symbolsArr[index - 1]);
                index += 1;
            }
        }
        return result;
    }

    private boolean greaterThanOrEqualTo(String fromSymbol, String toSymbol) {
        return this.subtract(fromSymbol, toSymbol) >= 0;
    }

    private Integer add(String symbolA, String symbolB) {
        Integer numberA = symbolConverter.convert(symbolA);
        Integer numberB = symbolConverter.convert(symbolB);
        return numberA + numberB;
    }

    private Integer subtract(String symbolA, String symbolB) {
        Integer numberA = symbolConverter.convert(symbolA);
        Integer numberB = symbolConverter.convert(symbolB);
        return numberA - numberB;
    }
}
