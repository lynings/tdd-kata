package pers.lyning.kata.merchantguidetothegalaxy;

import pers.lyning.kata.merchantguidetothegalaxy.operation.AddOperation;
import pers.lyning.kata.merchantguidetothegalaxy.operation.SubtractOperation;
import pers.lyning.kata.merchantguidetothegalaxy.operation.SymbolOperation;
import pers.lyning.kata.merchantguidetothegalaxy.validator.RepeatedOneTimesConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.validator.RepeatedThreeTimesConstraintValidator;
import pers.lyning.kata.merchantguidetothegalaxy.validator.SymbolsConstraintValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyning
 */
public class SymbolsOperationConverter {

    private String[] symbolsArr;

    private List<Constraint> constraints = Arrays.asList(
            new Constraint(new RepeatedOneTimesConstraintValidator(), new Exception("\"D\", \"L\", and \"V\" can never be repeated.")),
            new Constraint(new RepeatedThreeTimesConstraintValidator(), new Exception("The symbols \"I\", \"X\", \"C\", and \"M\" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.)"))
    );

    /**
     * 将symbols按照一定的规则转换成多组操作，以便于计算
     * 例如:
     * String symbols = "MMIV" => [Add("MM"), Subtract("IV")]
     * OR
     * String symbols = "MIV" => [Add("M"), Subtract("IV")]
     *
     * @param symbols
     * @return
     * @throws Exception
     */
    public List<SymbolOperation> convert(String symbols) throws Exception {
        this.validate(symbols);

        this.symbolsArr = symbols.split("");
        List<SymbolOperation> symbolGroup = new ArrayList<>();
        for (int index = 1, len = symbolsArr.length; index < len; index++) {
            if (this.greaterThanOrEqualTo(index - 1, index)) {
                if (!this.isOverflow(index)) {
                    if (this.greaterThanOrEqualTo(index, index + 1)) {
                        symbolGroup.add(new AddOperation(symbolsArr[index - 1], symbolsArr[index]));
                        index += 1;
                    } else {
                        symbolGroup.add(new AddOperation(symbolsArr[index - 1]));
                    }
                } else {
                    symbolGroup.add(new AddOperation(symbolsArr[index - 1], symbolsArr[index]));
                    index += 1;
                }
            } else {
                symbolGroup.add(new SubtractOperation(symbolsArr[index], symbolsArr[index - 1]));
                index += 1;
            }
        }
        return symbolGroup;
    }

    private boolean isOverflow(int index) {
        return (index + 1) > symbolsArr.length - 1;
    }

    private boolean greaterThanOrEqualTo(int sourceIndex, int targetIndex) {
        String fromSymbol = symbolsArr[sourceIndex],
                toSymbol = symbolsArr[targetIndex];
        return SymbolTable.getValue(fromSymbol) - SymbolTable.getValue(toSymbol) >= 0;
    }

    private void validate(String symbols) throws Exception {
        for (Constraint constraint : constraints) {
            if (!constraint.getValidator().validate(symbols)) {
                throw constraint.getException();
            }
        }
    }

    private class Constraint {
        private SymbolsConstraintValidator validator;
        private Exception exception;

        public Constraint(SymbolsConstraintValidator validator, Exception exception) {
            this.validator = validator;
            this.exception = exception;
        }

        public SymbolsConstraintValidator getValidator() {
            return validator;
        }

        public Exception getException() {
            return exception;
        }
    }
}
