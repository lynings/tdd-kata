package pers.lyning.kata.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Schema {

    private final Map<Character, String> flagToSchemaMap;

    private Schema(Map<Character, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schema parse(String schema) {
        String[] schemaArr = schema.split(",");
        Map<Character, String> flagToSchemaMap = new HashMap<>(schemaArr.length);
        for (String str : schemaArr) {
            flagToSchemaMap.put(str.substring(0, 1).charAt(0), str.substring(1));
        }
        return new Schema(flagToSchemaMap);
    }

    public String get(Character flag) {
        return this.flagToSchemaMap.get(flag);
    }
}
