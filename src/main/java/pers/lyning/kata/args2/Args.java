package pers.lyning.kata.args2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Args {
    private final String schema;
    private final String[] args;
    private Map<String, String> flagToValuesMap = new HashMap<>();
    private Map<String, String> flagToSchemaMap = new HashMap<>();
    private Map<String, ValueParser> schemaToValueParser = new HashMap<>();

    public Args(String schema, String[] args) {
        this.schema = schema;
        this.args = args;
        this.parseArgs();
        this.parseSchema();
        this.configParser();
    }

    private void configParser() {
        this.schemaToValueParser.put("", new BooleanValueParser());
        this.schemaToValueParser.put("*", new StringValueParser());
        this.schemaToValueParser.put("#", new IntegerValueParser());
        this.schemaToValueParser.put("##", new DoubleValueParser());
        this.schemaToValueParser.put("[*]", new StringArraysValueParser());
        this.schemaToValueParser.put("[#]", new IntegerArraysValueParser());
        this.schemaToValueParser.put("[##]", new DoubleArraysValueParser());
        this.schemaToValueParser.put("[&]", new SetValueParser());
        this.schemaToValueParser.put("[&&]", new MapValueParser());
    }

    public <T> T getValue(String flag) {
        if (!this.hasFlag(flag)) {
            throw new ArgsException("INVALID FLAG");
        }
        String schema = this.flagToSchemaMap.get(flag);
        String value = this.flagToValuesMap.get(flag);
        ValueParser valueParser = this.schemaToValueParser.get(schema);
        return (T) valueParser.parse(value);
    }

    public boolean hasFlag(String flag) {
        return this.flagToSchemaMap.containsKey(flag);
    }

    private void parseSchema() {
        String[] schemaArr = this.schema.split(",");
        for (String str : schemaArr) {
            this.flagToSchemaMap.put(str.substring(0, 1), str.substring(1));
        }
    }

    private void parseArgs() {
        for (int index = 0, len = args.length; index < len; index++) {
            if (args[index].startsWith("-")) {
                String flag = args[index];
                String value = this.hasValue(index) ? args[index += 1] : null;
                this.flagToValuesMap.put(flag.substring(1), value);
            }
        }
    }

    private boolean hasValue(int index) {
        return index + 1 <= args.length - 1;
    }
}
