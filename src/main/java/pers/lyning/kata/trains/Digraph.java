package pers.lyning.kata.trains;

import pers.lyning.kata.trains.strategy.RouteStrategy;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author lyning
 */
public class Digraph {

    private final List<Route> routes;

    public Digraph(List<Route> routes) {
        this.routes = routes;
    }

    public Integer calculate(RouteStrategy routeStrategy) throws Exception {
        this.validate();
        return routeStrategy.execute(this);
    }

    public List<Route> getRoutes() {
        return this.routes;
    }

    public List<Route> selectRouteWithOrigin(String origin) {
        return this.getRoutes()
                .stream()
                .filter(o -> o.getOrigin().equals(origin))
                .collect(toList());
    }

    private boolean isDuplicateNodeInRoute() throws Exception {
        for (Route route : this.getRoutes()) {
            if (route.getOrigin().equals(route.getDestination())) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateRoute() {
        return this.getRoutes()
                .stream()
                .map(route -> route.getName())
                .collect(toSet())
                .size() != this.getRoutes()
                .size();
    }

    private void validate() throws Exception {
        if (this.isDuplicateRoute()) {
            throw new Exception("duplicated route!");
        } else if (this.isDuplicateNodeInRoute()) {
            throw new Exception("origin and destination cannot be the same!");
        }
    }
}
