package pers.lyning.kata.merchantguidetothegalaxy.operation;

import pers.lyning.kata.merchantguidetothegalaxy.SymbolTable;

import java.util.Objects;

/**
 * @author lyning
 */
public class AddOperation implements SymbolOperation {

    private String symbolA;
    private String addedSymbolB;

    public AddOperation(String symbolA) {
        this(symbolA, null);
    }

    public AddOperation(String symbolA, String addedSymbolB) {
        this.symbolA = symbolA;
        this.addedSymbolB = addedSymbolB;
    }

    @Override
    public int operate() {
        return Objects.isNull(addedSymbolB)
                ? SymbolTable.getValue(symbolA)
                : this.add(symbolA, addedSymbolB);
    }

    private Integer add(String symbolA, String symbolB) {
        Integer numberA = SymbolTable.getValue(symbolA);
        Integer numberB = SymbolTable.getValue(symbolB);
        return numberA + numberB;
    }
}
