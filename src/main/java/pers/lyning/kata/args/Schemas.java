package pers.lyning.kata.args;

import pers.lyning.kata.args.exception.ArgsException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
class Schemas {
    private final Map<Character, String> flagToSchemaMap;
    private final String[] schemas;

    public Schemas(String schemas) {
        this.schemas = schemas.split(",");
        flagToSchemaMap = new HashMap<>();
        this.parse();
    }

    private void parse() {
        for (String schema : schemas) {
            flagToSchemaMap.put(schema.charAt(0), schema.substring(1));
        }
    }

    public String get(Character flag) {
        if (!flagToSchemaMap.containsKey(flag)) {
            throw new ArgsException("INCORRECT SCHEMA.");
        }
        return flagToSchemaMap.get(flag);
    }
}
