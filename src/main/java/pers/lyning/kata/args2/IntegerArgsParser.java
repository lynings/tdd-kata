package pers.lyning.kata.args2;

import java.util.Optional;

/**
 * @author lyning
 */
public class IntegerArgsParser implements ArgsParser<Integer> {

    @Override
    public Integer parse(String values) {
        return Optional
                .ofNullable(values)
                .map(Integer::valueOf)
                .orElse(0);
    }
}
