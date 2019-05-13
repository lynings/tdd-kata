package pers.lyning.kata.args.valueparser;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lyning
 */
public class DoubleArraysValueParser implements ValueParser<Double[]> {

    @Override
    public String getDescription() {
        return "schema '[##]' default return empty double array(such as schema: d[##], args: -d), when value existed then return specified double array(such as schema: d[##], args: -d 1.0 2.5 3.4).";
    }

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
        } catch (Exception e) {
            throw new ArgsException("The value of args must be an double arrays，such as -d[##] 1.0 2.5 3.14");
        }
    }
}
