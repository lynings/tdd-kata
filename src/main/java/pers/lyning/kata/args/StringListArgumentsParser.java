package pers.lyning.kata.args;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class StringListArgumentsParser implements ArgumentParser<List<String>> {

    @Override
    public List<String> parse(String args) {
        List<String> results = new ArrayList<>();
        String[] argsArr = args.split(" ");
        for (int i = 1; i < argsArr.length; i++) {
            results.add(argsArr[i]);
        }
        return results;
    }

    @Override
    public String getFlag() {
        return "-g";
    }
}
