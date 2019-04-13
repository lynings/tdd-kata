package pers.lyning.kata.args2;

import java.util.Optional;

/**
 * @author lyning
 */
public class IntegerValueParser implements ValueParser<Integer> {

    @Override
    public Integer parse(String values) {
        return Optional
                .ofNullable(values)
                .map(Integer::valueOf)
                .orElse(0);
    }
}
