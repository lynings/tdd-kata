package pers.lyning.kata.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyning
 */
public class Arguments {

    private String args;
    private Map<String, ArgumentParser> flagToArgsParserMap = new HashMap<>();

    public Arguments(String args) {
        this.args = args;
        this.config();
    }

    private void config() {
        this.flagToArgsParserMap.put("-s", new StringArgumentParser());
        this.flagToArgsParserMap.put("-i", new IntegerArgumentParser());
        this.flagToArgsParserMap.put("-g", new StringListArgumentsParser());
        this.flagToArgsParserMap.put("-d", new IntegerListArgumentParser());
        this.flagToArgsParserMap.put("-f", new FileArgumentParser());
    }

    private Object parse(String flag) {
        String newArgs = this.getArgsOfFlag(flag);
        return this.flagToArgsParserMap.get(flag).parse(newArgs.trim());
    }

    private String getArgsOfFlag(String flag) {
        StringBuffer newArgs = new StringBuffer(flag);
        String[] argsArr = args.split(" ");
        for (int i = 0, len = argsArr.length; i < len; i++) {
            if (flag.equals(argsArr[i])) {
                for (int j = i + 1; j < len; j++) {
                    if (this.isFlag(argsArr[j])) {
                        break;
                    } else {
                        newArgs.append(" " + argsArr[j]);
                    }
                }
                break;
            }
        }
        return newArgs.toString();
    }

    private boolean isFlag(String word) {
        return flagToArgsParserMap.containsKey(word);
    }

    public <T> T getValue(String flag) {
        return (T) this.parse("-" + flag);
    }
}
