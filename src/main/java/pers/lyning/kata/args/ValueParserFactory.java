package pers.lyning.kata.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class ValueParserFactory {

    private static final Map<String, ValueParser> schemaToValueParserMap = new HashMap<>();

    static {
        schemaToValueParserMap.put("", new BooleanValueParser());
        schemaToValueParserMap.put("*", new StringValueParser());
        schemaToValueParserMap.put("##", new DoubleValueParser());
        schemaToValueParserMap.put("[*]", new StringArraysValueParser());
        schemaToValueParserMap.put("[#]", new IntegerArraysValueParser());
        schemaToValueParserMap.put("[##]", new DoubleArraysValueParser());
        schemaToValueParserMap.put("[&]", new SetValueParser());
        schemaToValueParserMap.put("[&&]", new MapValueParser());
    }

    public static ValueParser getInstance(String schema) {
        if (!schemaToValueParserMap.containsKey(schema)) {
            throw new ArgsException("SCHEMA NOT IMPLEMENTED");
        }
        return schemaToValueParserMap.get(schema);
    }
}
