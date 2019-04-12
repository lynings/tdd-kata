package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lyning
 */
public class DoubleArraysArgsParser implements ArgsParser<Double[]> {

    @Override
    public Double[] parse(String values) {
        if (Objects.isNull(values)) {
            return new Double[]{};
        }
        return Arrays.asList(values.split(" "))
                .stream()
                .map(Double::valueOf)
                .toArray(Double[]::new);
    }
}
