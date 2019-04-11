package pers.lyning.kata.merchantguidetothegalaxy.operation;

import pers.lyning.kata.merchantguidetothegalaxy.validator.SubtractionConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.SymbolTable;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SymbolsConstraintValidator;

/**
 * @author lyning
 */
public class SubtractOperation implements SymbolOperation {

    private String symbolA;
    private String symbolB;

    public SubtractOperation(String symbolA, String symbolB) {
        this.symbolA = symbolA;
        this.symbolB = symbolB;
    }

    @Override
    public int operate() {
        this.validate();

        return this.subtract(symbolA, symbolB);
    }

    private void validate() throws RuntimeException {
        SymbolsConstraintValidator validator = new SubtractionConstraintValidator();
        if (validator.validate(symbolA.concat(symbolB))) {
            throw new RuntimeException(symbolB + " cannot subtracted by " + symbolA);
        }
    }

    private Integer subtract(String symbolA, String symbolB) {
        Integer numberA = SymbolTable.getValue(symbolA);
        Integer numberB = SymbolTable.getValue(symbolB);
        return numberA - numberB;
    }
}
