package pers.lyning.kata.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Schema {

    private final Map<String, String> flagToSchemaMap;

    private Schema(Map<String, String> flagToSchemaMap) {
        this.flagToSchemaMap = flagToSchemaMap;
    }

    public static Schema parse(String schema) {
        String[] schemaArr = schema.split(",");
        Map<String, String> flagToSchemaMap = new HashMap<>(schemaArr.length);
        for (String str : schemaArr) {
            flagToSchemaMap.put(str.substring(0, 1), str.substring(1));
        }
        return new Schema(flagToSchemaMap);
    }

    public String get(String flag) {
        return this.flagToSchemaMap.get(flag);
    }
}
