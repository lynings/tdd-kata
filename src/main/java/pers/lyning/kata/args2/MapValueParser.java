package pers.lyning.kata.args2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lyning
 */
public class MapValueParser implements ValueParser<Map<String, String>> {

    @Override
    public Map<String, String> parse(String values) {
        if (Objects.isNull(values)) {
            return new HashMap<>(0);
        }
        String[] kvArr = values.split(",");
        Map<String, String> map = new HashMap<>(kvArr.length);
        try {
            for (String vkString : kvArr) {
                String[] kv = vkString.split(":");
                map.put(kv[0], kv[1]);
            }
        } catch (Exception e) {
            throw new ArgsException("The value of args must be an map，such as -m[&&] key1:val1,key2:val2,...");
        }
        return map;
    }
}
