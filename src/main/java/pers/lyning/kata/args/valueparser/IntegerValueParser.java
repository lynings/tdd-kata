package pers.lyning.kata.args.valueparser;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.Optional;

/**
 * @author lyning
 */
public class IntegerValueParser implements ValueParser<Integer> {

    @Override
    public String getDescription() {
        return "schema '#' default return 0(such as schema: i#, args: -i), when value existed then return specified int value(such as schema: i#, args: -i 1).";
    }

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
