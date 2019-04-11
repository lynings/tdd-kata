package pers.lyning.kata.merchantguidetothegalaxy;

import pers.lyning.kata.merchantguidetothegalaxy.operation.SymbolOperation;

import java.util.List;

/**
 * @author lyning
 */
public class SymbolCalculator {

    private SymbolsOperationConverter symbolsOperationConverter = new SymbolsOperationConverter();

    public Integer calc(String symbols) throws Exception {
        List<SymbolOperation> symbolGroup = symbolsOperationConverter.convert(symbols);
        return symbolGroup
                .stream()
                .map(SymbolOperation::operate)
                .reduce(Integer::sum)
                .get();
    }
}
