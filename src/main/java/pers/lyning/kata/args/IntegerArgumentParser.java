package pers.lyning.kata.args;

/**
 * @author lyning
 */
public class IntegerArgumentParser implements ArgumentParser<Integer> {

    @Override
    public Integer parse(String args) {
        String result = args.replace(this.getFlag(), "").trim();
        return Integer.valueOf(result);
    }

    @Override
    public String getFlag() {
        return "-i";
    }
}
