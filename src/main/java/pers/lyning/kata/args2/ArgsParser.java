package pers.lyning.kata.args2;

/**
 * @param <T>
 * @author lyning
 */
public interface ArgsParser<T> {

    /**
     * 解析 values 并返回适当的数据类型
     *
     * @param values
     * @return
     */
    T parse(String values);
}