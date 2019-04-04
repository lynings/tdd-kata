package pers.lyning.kata.trains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lyning
 */
public class PointToPointDistanceConstraintRouteStrategy implements RouteStrategy {

    private Digraph digraph;
    private final Route route;
    private final Set<String> routes;
    private final DistanceConstraint distanceConstraint;

    public PointToPointDistanceConstraintRouteStrategy(Route route, DistanceConstraint distanceConstraint) {
        this.route = route;
        this.distanceConstraint = distanceConstraint;
        routes = new HashSet<>();
    }

    @Override
    public Integer calculate(Digraph digraph) {
        this.digraph = digraph;
        return this.calculateTimesOfRoutes();
    }

    private Integer calculateTimesOfRoutes() {
        List<Edge> edgeList = this.digraph.getEdgesOfOrigin(route.getOrigin());
        for (Edge edge : edgeList) {
            this.depthFirstSearch(edge, edge.getName(), edge.getDistance());
        }
        return routes.size();
    }

    private void depthFirstSearch(Edge origin, String route, Integer distance) {
        if (!this.distanceConstraint.isValid(distance)) {
            return;
        }

        if (this.route.isArrived(route) && this.distanceConstraint.isValid(distance)) {
            routes.add(route);
        }

        List<Edge> edges = this.digraph.getEdgesOfOrigin(origin.getEndNode());
        for (Edge edge : edges) {
            this.depthFirstSearch(edge, route.concat(edge.getEndNode()), distance + edge.getDistance());
        }
    }
}

