package pers.lyning.kata.args.factory;

import pers.lyning.kata.args.exception.ArgsException;
import pers.lyning.kata.args.valueparser.*;

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
        schemaToValueParserMap.put("#", new IntegerValueParser());
        schemaToValueParserMap.put("##", new DoubleValueParser());
        schemaToValueParserMap.put("[*]", new StringArraysValueParser());
        schemaToValueParserMap.put("[#]", new IntegerArraysValueParser());
        schemaToValueParserMap.put("[##]", new DoubleArraysValueParser());
        schemaToValueParserMap.put("[&]", new SetValueParser());
        schemaToValueParserMap.put("[&&]", new MapValueParser());
        schemaToValueParserMap.put("[help]", new HelpValueParser());
    }

    public static ValueParser getInstance(String schema) {
        if (!schemaToValueParserMap.containsKey(schema)) {
            throw new ArgsException("SCHEMA NOT IMPLEMENTED");
        }
        return schemaToValueParserMap.get(schema);
    }
}
