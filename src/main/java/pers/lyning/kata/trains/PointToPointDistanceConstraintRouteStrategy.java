package pers.lyning.kata.trains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * @author lyning
 */
public class PointToPointDistanceConstraintRouteStrategy implements RouteStrategy {

    private List<Edge> edges;
    private String origin;
    private String destination;
    private DistanceConstraint distanceConstraint;

    public PointToPointDistanceConstraintRouteStrategy(List<Edge> edges, String route, DistanceConstraint distanceConstraint) {
        this.edges = edges;
        this.origin = route.split("")[0];
        this.destination = route.split("")[1];
        this.distanceConstraint = distanceConstraint;
    }

    @Override
    public Integer calculate() {
        Set<String> routes = this.getRoutes();
        return routes.size();
    }

    private Set<String> getRoutes() {
        Set<String> routes = new HashSet<>();

        List<Edge> edgeList = this.getEdgesWithOrigin(this.origin);
        for (Edge edge : edgeList) {
            this.includeRoutesAndSearch(edge, edge.getOrigin() + edge.getDestination(), edge.getDistance(), routes);
        }
        return routes;
    }

    private void includeRoutesAndSearch(Edge origin, String route, Integer distance, Set<String> routes) {
        if (!this.distanceConstraint.isValid(distance)) {
            return;
        }

        if (this.isArrivedToDestination(route) && this.distanceConstraint.isValid(distance)) {
            routes.add(route);
        }

        List<Edge> edgeList = this.getEdgesWithOrigin(origin.getDestination());
        for (Edge edge : edgeList) {
            this.includeRoutesAndSearch(edge, route + edge.getDestination(), distance + edge.getDistance(), routes);
        }
    }

    private boolean isArrivedToDestination(String route) {
        if (route.startsWith(this.origin)
                && route.endsWith(this.destination)) {
            return true;
        }
        return false;
    }

    private List<Edge> getEdgesWithOrigin(String origin) {
        return this.edges
                .stream()
                .filter(o -> o.getOrigin().equals(origin))
                .collect(toList());
    }
}

