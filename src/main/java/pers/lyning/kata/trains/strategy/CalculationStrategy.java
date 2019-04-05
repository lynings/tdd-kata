package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;

/**
 * 路线计算策略接口
 *
 * @author lyning
 */
public interface CalculationStrategy {

    /**
     * 执行
     *
     * @param context 有向图
     * @return
     * @throws Exception
     */
    Integer execute(Digraph context) throws Exception;
}
