package pers.lyning.kata.trains;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class Digraph {

    private List<Edge> edges;

    public Digraph(List<Edge> edges) {
        this.edges = edges;
    }

    public Integer calculate(RouteStrategy strategy) throws Exception {
        return strategy.calculate(this);
    }

    public List<Edge> getEdgesOfOrigin(String origin) {
        return this.edges
                .stream()
                .filter(o -> o.getStartNode().equals(origin))
                .collect(toList());
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
