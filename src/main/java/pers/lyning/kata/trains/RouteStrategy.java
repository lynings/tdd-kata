package pers.lyning.kata.trains;

/**
 * 路线策略接口
 *
 * @author lyning
 */
public interface RouteStrategy {

    /**
     * 计算路线接口
     *
     * @return
     * @throws Exception
     */
    Integer calculate() throws Exception;
}
