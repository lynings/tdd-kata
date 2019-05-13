package pers.lyning.kata.args;

import pers.lyning.kata.args.factory.ValueParserFactory;
import pers.lyning.kata.args.valueparser.ValueParser;

/**
 * @author lyning
 */
public class Args {

    private final ArgsParser argsParser;
    private final Schemas schemas;

    public Args(String schema, String[] args) {
        this.argsParser = new ArgsParser(args);
        this.schemas = new Schemas(schema);
    }

    public <T> T getValue(Character flag) {
        String value = this.argsParser.getValue(flag);
        ValueParser<T> valueParser = this.getValueParser(flag);
        return valueParser.parse(value);
    }

    private ValueParser getValueParser(Character flag) {
        String schema = this.schemas.get(flag);
        ValueParser valueParser = ValueParserFactory.getInstance(schema);
        return valueParser;
    }
}