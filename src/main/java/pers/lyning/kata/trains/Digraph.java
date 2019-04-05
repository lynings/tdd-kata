package pers.lyning.kata.trains;

import pers.lyning.kata.trains.strategy.RouteStrategy;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
public class Digraph {

    private List<Edge> edges;

    public Digraph(List<Edge> edges) {
        this.edges = edges;
    }

    public Integer calculate(RouteStrategy routeStrategy) throws Exception {
        this.validate();
        return routeStrategy.execute(this);
    }

    private void validate() throws Exception {
        if (this.isDuplicateEdge()) {
            throw new Exception("duplicated route!");
        } else if (this.isDuplicateNodeInEdge()) {
            throw new Exception("origin and destination cannot be the same!");
        }
    }

    private boolean isDuplicateEdge() {
        return this.getEdges()
                .stream()
                .map(edge -> edge.getName())
                .collect(toSet()).size() != this.getEdges().size();
    }

    private boolean isDuplicateNodeInEdge() throws Exception {
        for (Edge edge : this.getEdges()) {
            if (edge.getStartNode().equals(edge.getEndNode())) {
                return true;
            }
        }
        return false;
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
