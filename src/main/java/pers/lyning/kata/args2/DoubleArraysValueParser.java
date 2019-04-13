package pers.lyning.kata.args2;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lyning
 */
public class DoubleArraysValueParser implements ValueParser<Double[]> {

    @Override
    public Double[] parse(String values) {
        if (Objects.isNull(values)) {
            return new Double[]{};
        }
        try {
        return Arrays.asList(values.split(" "))
                .stream()
                .map(Double::valueOf)
                .toArray(Double[]::new);
        }catch (Exception e) {
            throw new ArgsException("The value of args must be an double arrays，such as -d[##] 1.0 2.5 3.14");
        }
    }
}
