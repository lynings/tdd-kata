package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Edge;
import pers.lyning.kata.trains.Route;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lyning
 */
public class CalculationDistanceConstraintRoutesStrategy implements Strategy {

    private Digraph digraph;
    private final Route route;
    private final Set<String> routes;
    private final RouteSpecification routeSpecification;

    public CalculationDistanceConstraintRoutesStrategy(Route route, RouteSpecification routeSpecification) {
        this.route = route;
        this.routeSpecification = routeSpecification;
        routes = new HashSet<>();
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        this.depthFirstSearch();
        return routes.size();
    }

    private void depthFirstSearch() {
        List<Edge> edgeList = this.digraph.getEdgesOfOrigin(route.getOrigin());
        for (Edge edge : edgeList) {
            this.depthFirstSearch(edge, edge.getName(), edge.getDistance());
        }
    }

    private void depthFirstSearch(Edge origin, String route, Integer distance) {
        if (!this.routeSpecification.isValid(distance)) {
            return;
        }

        if (this.route.isEquals(route) && this.routeSpecification.isValid(distance)) {
            routes.add(route);
        }

        List<Edge> edges = this.digraph.getEdgesOfOrigin(origin.getEndNode());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, route.concat(edge.getEndNode()), distance + edge.getDistance());
        }
    }
}

