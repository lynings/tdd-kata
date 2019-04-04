package pers.lyning.kata.trains;

import java.util.List;

/**
 * @author lyning
 */
public class Digraph {

    private List<Edge> edges;

    public Digraph(List<Edge> edges) {
        this.edges = edges;
    }

    public Integer calculate(RouteStrategy strategy) throws Exception {
        return strategy.calculate();
    }
}
