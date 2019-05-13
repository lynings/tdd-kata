package pers.lyning.kata.args.valueparser;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author lyning
 */
public class IntegerArraysValueParser implements ValueParser<Integer[]> {

    @Override
    public String getDescription() {
        return "schema '[#]' default return empty int array(such as schema: i[#], args: -i), when value existed then return specified int array(such as schema: i[#], args: -d 1 2 3 -4).";
    }

    @Override
    public Integer[] parse(String values) {
        if (Objects.isNull(values)) {
            return new Integer[]{};
        }
        try {
            return Arrays.asList(values.split(" "))
                    .stream()
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
        } catch (Exception e) {
            throw new ArgsException("The value of args must be an int arrays，such as -i[#] 0 1 2");
        }
    }
}
