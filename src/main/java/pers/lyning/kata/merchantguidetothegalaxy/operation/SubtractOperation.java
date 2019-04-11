package pers.lyning.kata.merchantguidetothegalaxy.operation;

import pers.lyning.kata.merchantguidetothegalaxy.SymbolTable;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SubtractionConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SymbolsConstraintValidator;

/**
 * @author lyning
 */
public class SubtractOperation implements SymbolOperation {


    private final String symbol;
    private final String subtractSymbol;

    public SubtractOperation(String symbol, String subtractSymbol) {
        this.symbol = symbol;
        this.subtractSymbol = subtractSymbol;
    }

    @Override
    public int operate() {
        this.validate();

        return this.subtract(symbol, subtractSymbol);
    }

    private void validate() throws RuntimeException {
        SymbolsConstraintValidator validator = new SubtractionConstraintValidator();
        if (!validator.validate(subtractSymbol.concat(symbol))) {
            throw new RuntimeException(subtractSymbol + " cannot subtracted by " + symbol);
        }
    }

    private Integer subtract(String symbol, String subtractSymbol) {
        Integer number = SymbolTable.getValue(symbol);
        Integer subtractNumber = SymbolTable.getValue(subtractSymbol);
        return number - subtractNumber;
    }
}
