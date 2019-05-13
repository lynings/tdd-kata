package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Route;

import java.util.Optional;

/**
 * 用于计算从起点到终点存在的单一可行路线
 *
 * @author lyning
 */
public class DistanceRouteStrategy implements RouteStrategy {

    public static final Integer NO_SUCH_ROUTE = -1;
    private final String route;
    private Digraph digraph;

    public DistanceRouteStrategy(String route) {
        this.route = route;
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        return this.getDistance();
    }

    private Optional<Route> findRoute(String route) {
        Optional<Route> routeOptional = this.digraph.getRoutes()
                .stream()
                .filter(o -> o.getName()
                        .equals(route))
                .findFirst();
        return routeOptional;
    }

    private Integer getDistance() {
        Integer distance = 0;
        String[] nodeArr = this.route.split("");
        for (int i = 1, len = nodeArr.length; i < len; i++) {
            String route = nodeArr[i - 1] + nodeArr[i];
            Optional<Route> routeOptional = this.findRoute(route);
            if (routeOptional.isPresent()) {
                distance += routeOptional.get()
                        .getDistance();
            } else {
                return NO_SUCH_ROUTE;
            }
        }
        return distance;
    }
}
