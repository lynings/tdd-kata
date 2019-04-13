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
        return Arrays.asList(values.split(" "))
                .stream()
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
