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
        this.flagToSchemaMap = new HashMap<>();
        this.parse();
    }

    public String get(Character flag) {
        if (!this.flagToSchemaMap.containsKey(flag)) {
            throw new ArgsException("INCORRECT SCHEMA.");
        }
        return this.flagToSchemaMap.get(flag);
    }

    private void parse() {
        for (String schema : this.schemas) {
            this.flagToSchemaMap.put(schema.charAt(0), schema.substring(1));
        }
    }
}
