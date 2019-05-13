package pers.lyning.kata.args.valueparser;

import pers.lyning.kata.args.factory.ValueParserFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author lyning
 */
public class HelpValueParser implements ValueParser<Map<String, String>> {
    private final Map<String, String> schemaToDescriptionMap = new HashMap() {{
        this.put("", ValueParserFactory.getInstance("")
                .getDescription());
        this.put("*", ValueParserFactory.getInstance("*")
                .getDescription());
        this.put("#", ValueParserFactory.getInstance("#")
                .getDescription());
        this.put("##", ValueParserFactory.getInstance("##")
                .getDescription());
        this.put("[*]", ValueParserFactory.getInstance("[*]")
                .getDescription());
        this.put("[#]", ValueParserFactory.getInstance("[#]")
                .getDescription());
        this.put("[##]", ValueParserFactory.getInstance("[##]")
                .getDescription());
        this.put("[&]", ValueParserFactory.getInstance("[&]")
                .getDescription());
        this.put("[&&]", ValueParserFactory.getInstance("[&&]")
                .getDescription());
        this.put("[help]", HelpValueParser.this.getDescription());
    }};

    @Override
    public String getDescription() {
        return "schema '[help]' default return all schema description(such as schema:h[help], args:-h), otherwise return specified schema description(such as schema:h[help], args:-h [*]).";
    }

    @Override
    public Map<String, String> parse(final String schemas) {
        return Optional
                .ofNullable(schemas)
                .map((s) -> {
                    Map<String, String> map = new HashMap<>(1);
                    String[] schemaArr = s.split(" ");
                    for (String schema : schemaArr) {
                        map.put(schema, this.schemaToDescriptionMap.get(schema));
                    }
                    return map;
                })
                .orElse(this.schemaToDescriptionMap);
    }
}
