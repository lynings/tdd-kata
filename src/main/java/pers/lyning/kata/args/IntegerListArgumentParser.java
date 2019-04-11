package pers.lyning.kata.args;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyning
 */
public class IntegerListArgumentParser implements ArgumentParser<List<Integer>> {

    @Override
    public List<Integer> parse(String args) {
        List<Integer> results = new ArrayList<>();
        String[] argsArr = args.split(" ");
        for (int i = 1; i < argsArr.length; i++) {
            results.add(Integer.valueOf(argsArr[i].trim()));
        }
        return results;
    }

    @Override
    public String getFlag() {
        return "-g";
    }
}
