package pers.lyning.kata.args.valueparser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
public class SetValueParser implements ValueParser<Set<String>> {

    @Override
    public String getDescription() {
        return "schema '[&]' default return empty set(such as schema: s[&], args: -s), when value existed then return specified set value(such as schema: s[&], args: -s a a b c).";
    }

    @Override
    public Set<String> parse(String values) {
        if (Objects.isNull(values)) {
            return new HashSet<>(0);
        }
        return Arrays
                .asList(values.split(" "))
                .stream()
                .collect(toSet());
    }
}
