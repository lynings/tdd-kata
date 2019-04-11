package pers.lyning.kata.merchantguidetothegalaxy.operation;

import pers.lyning.kata.merchantguidetothegalaxy.SymbolTable;

import java.util.Objects;

/**
 * @author lyning
 */
public class AddOperation implements SymbolOperation {

    private String symbolA;
    private String symbolB;

    public AddOperation(String symbolA) {
        this(symbolA, null);
    }

    public AddOperation(String symbolA, String symbolB) {
        this.symbolA = symbolA;
        this.symbolB = symbolB;
    }

    @Override
    public int operate() {
        return Objects.isNull(symbolB)
                ? SymbolTable.getValue(symbolA)
                : this.add(symbolA, symbolB);
    }

    private Integer add(String symbolA, String symbolB) {
        Integer numberA = SymbolTable.getValue(symbolA);
        Integer numberB = SymbolTable.getValue(symbolB);
        return numberA + numberB;
    }
}
