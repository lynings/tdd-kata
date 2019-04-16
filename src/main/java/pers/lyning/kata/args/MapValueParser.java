package pers.lyning.kata.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lyning
 */
public class MapValueParser implements ValueParser<Map<String, String>> {

    @Override
    public Map<String, String> parse(String values) {
        if (Objects.isNull(values)) {
            return new HashMap<>(0);
        }
        try {
            return Arrays
                    .asList(values.split(","))
                    .stream()
                    .map(kv -> kv.split(":"))
                    .collect(Collectors.toMap(a -> a[0], a -> a[1]));
        } catch (Exception e) {
            throw new ArgsException("The value of args must be an map，such as -m[&&] key1:val1,key2:val2,...");
        }
    }
}
