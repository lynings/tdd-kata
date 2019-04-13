package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lyning
 */
public class IntegerArraysValueParser implements ValueParser<Integer[]> {

    @Override
    public Integer[] parse(String values) {
        if (Objects.isNull(values)) {
            return new Integer[]{};
        }
        try {
            return Arrays.asList(values.split(" "))
                    .stream()
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
        } catch (Exception e) {
            throw new ArgsException("The value of args must be an int arrays，such as -i[#] 0 1 2");
        }
    }
}
