package pers.lyning.kata.args.valueparser;

/**
 * @param <T>
 * @author lyning
 */
public interface ValueParser<T> {

    /**
     * 获取描述信息
     *
     * @return
     */
    String getDescription();

    /**
     * 解析 values 并返回适当的数据类型
     *
     * @param values
     * @return
     */
    T parse(String values);
}
