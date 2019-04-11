package pers.lyning.kata.args;

/**
 * @author lyning
 */
public class StringArgumentParser implements ArgumentParser<String> {

    @Override
    public String parse(String args) {
        String result = args.replace(this.getFlag(), "");
        return result.trim();
    }

    @Override
    public String getFlag() {
        return "-s";
    }
}
