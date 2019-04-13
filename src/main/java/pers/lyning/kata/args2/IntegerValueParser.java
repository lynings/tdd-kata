package pers.lyning.kata.args2;

import java.util.Optional;

/**
 * @author lyning
 */
public class IntegerValueParser implements ValueParser<Integer> {

    @Override
    public Integer parse(String values) {
        try {
            return Optional
                    .ofNullable(values)
                    .map(Integer::valueOf)
                    .orElse(0);
        } catch (Exception e) {
            throw new ArgsException("The value of args must be an integer，such as -i 1");
        }
    }
}
