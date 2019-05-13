package pers.lyning.kata.args.valueparser;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.Optional;

/**
 * @author lyning
 */
public class DoubleValueParser implements ValueParser<Double> {

    @Override
    public String getDescription() {
        return "schema '##' default return 0.0(such as schema: d##, args: -d), when value existed then return specified double value(such as schema: d##, args: -d 1.0).";
    }

    @Override
    public Double parse(String values) {
        try {
            return Optional
                    .ofNullable(values)
                    .map(Double::valueOf)
                    .orElse(0.0);
        } catch (Exception e) {
            throw new ArgsException("The value of args must be an double，such as -d 2.5");
        }
    }
}
