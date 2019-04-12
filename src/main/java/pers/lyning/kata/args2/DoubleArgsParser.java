package pers.lyning.kata.args2;

import java.util.Optional;

/**
 * @author lyning
 */
public class DoubleArgsParser implements ArgsParser<Double> {

    @Override
    public Double parse(String values) {
        return Optional
                .ofNullable(values)
                .map(Double::valueOf)
                .orElse(0.0);
    }
}