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
public class CalculationStopsConstraintRoutesStrategy implements Strategy {

    private Digraph digraph;
    private final Route route;
    private final RouteSpecification routeSpecification;

    public CalculationStopsConstraintRoutesStrategy(Route route, RouteSpecification routeSpecification) {
        this.route = route;
        this.routeSpecification = routeSpecification;
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        Set<String> routes = this.getRoutes();
        return routes.size();
    }

    private Set<String> getRoutes() {
        Set<String> routes = new HashSet<>();

        List<Edge> edges = this.digraph.getEdgesOfOrigin(this.route.getOrigin());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, edge.getName(), routes);
        }
        return routes;
    }

    private void depthFirstSearch(Edge partOfRoute, String route, Set<String> routes) {
        // 打破循环，避免路线陷入无线循环
        if (this.isInfiniteLoop(partOfRoute.getName(), route)) {
            return;
        }

        if (this.route.isEquals(route) && this.routeSpecification.isValid(route.length() - 1)) {
            routes.add(route);
            return;
        }

        List<Edge> edges = this.digraph.getEdgesOfOrigin(partOfRoute.getEndNode());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, route + edge.getEndNode(), routes);
        }
    }

    private boolean isInfiniteLoop(String edge, String route) {
        return (route.length() - route.split(edge).length) / 2 > this.routeSpecification.getValue();
    }
}