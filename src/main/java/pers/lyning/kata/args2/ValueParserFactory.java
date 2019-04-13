package pers.lyning.kata.args2;

/**
 * @author lyning
 */
public class ValueParserFactory {

    public static ValueParser getInstance(String schema) {
        switch (schema) {
            case "":
                return new BooleanValueParser();
            case "*":
                return new StringValueParser();
            case "#":
                return new IntegerValueParser();
            case "##":
                return new DoubleValueParser();
            case "[*]":
                return new StringArraysValueParser();
            case "[#]":
                return new IntegerArraysValueParser();
            case "[##]":
                return new DoubleArraysValueParser();
            case "[&]":
                return new SetValueParser();
            case "[&&]":
                return new MapValueParser();
            default:
                throw new ArgsException("SCHEMA NOT IMPLEMENTED");
        }
    }
}
