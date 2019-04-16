package pers.lyning.kata.args.valueparser;

/**
 * @param <T>
 * @author lyning
 */
public interface ValueParser<T> {

    /**
     * 解析 values 并返回适当的数据类型
     *
     * @param values
     * @return
     */
    T parse(String values);
}
