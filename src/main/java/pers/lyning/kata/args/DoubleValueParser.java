package pers.lyning.kata.args;

import java.util.Optional;

/**
 * @author lyning
 */
public class DoubleValueParser implements ValueParser<Double> {

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
