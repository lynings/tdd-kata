package pers.lyning.kata.args2;

/**
 * @author lyning
 */
public class ArgsParser {

    private final Args args;
    private final Schema schema;

    public ArgsParser(String schema, String[] args) {
        this.args = Args.parse(args);
        this.schema = Schema.parse(schema);
    }

    public <T> T getValue(String flag) {
        String value = this.args.getValue(flag);
        ValueParser<T> valueParser = this.getValueParser(flag);
        return valueParser.parse(value);
    }

    public boolean hasFlag(String flag) {
        return this.args.containsFlag(flag);
    }

    private ValueParser getValueParser(String flag) {
        String schema = this.schema.get(flag);
        ValueParser valueParser = ValueParserFactory.getInstance(schema);
        return valueParser;
    }
}
