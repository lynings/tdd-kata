package pers.lyning.kata.merchantguidetothegalaxy.operation;

import pers.lyning.kata.merchantguidetothegalaxy.SymbolTable;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SubtractionConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SymbolsConstraintValidator;

/**
 * @author lyning
 */
public class SubtractOperation implements SymbolOperation {


    private final String subtractSymbol;
    private final String symbol;

    public SubtractOperation(String symbol, String subtractSymbol) {
        this.symbol = symbol;
        this.subtractSymbol = subtractSymbol;
    }

    @Override
    public int operate() {
        this.validate();

        return this.subtract(this.symbol, this.subtractSymbol);
    }

    private Integer subtract(String symbol, String subtractSymbol) {
        Integer number = SymbolTable.getValue(symbol);
        Integer subtractNumber = SymbolTable.getValue(subtractSymbol);
        return number - subtractNumber;
    }

    private void validate() throws RuntimeException {
        SymbolsConstraintValidator validator = new SubtractionConstraintValidator();
        if (!validator.validate(this.subtractSymbol.concat(this.symbol))) {
            throw new RuntimeException(this.subtractSymbol + " cannot subtracted by " + this.symbol);
        }
    }
}
