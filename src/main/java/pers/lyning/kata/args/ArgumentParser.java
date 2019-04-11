package pers.lyning.kata.args;

/**
 * @param <T>
 * @author lyning
 */
public interface ArgumentParser<T> {

    /**
     * 解析参数
     *
     * @param args
     * @return
     */
    T parse(String args);

    String getFlag();
}
