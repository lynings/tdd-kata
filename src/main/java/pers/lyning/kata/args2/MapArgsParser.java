package pers.lyning.kata.args2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author lyning
 */
public class MapArgsParser implements ArgsParser<Map<String, String>> {

    @Override
    public Map<String, String> parse(String values) {
        if (Objects.isNull(values)) {
            return new HashMap<>(0);
        }
        String[] kvArr = values.split(",");
        Map<String, String> map = new HashMap<>(kvArr.length);
        for (String vkString : kvArr) {
            String[] kv = vkString.split(":");
            map.put(kv[0], kv[1]);
        }
        return map;
    }
}
