package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;

/**
 * 路线策略接口
 *
 * @author lyning
 */
public interface RouteStrategy {

    /**
     * 计算
     *
     * @param digraph 有向图
     * @return
     * @throws Exception
     */
    Integer calculate(Digraph digraph) throws Exception;
}
