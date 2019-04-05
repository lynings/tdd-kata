package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Edge;

import java.util.Optional;

/**
 * 用于计算从起点到终点存在的单一可行路线
 *
 * @author lyning
 */
public class DistanceRouteStrategy implements RouteStrategy {

    private Digraph digraph;
    private String route;
    public static final Integer NO_SUCH_ROUTE = -1;

    public DistanceRouteStrategy(String route) {
        this.route = route;
    }

    @Override
    public Integer execute(Digraph digraph) {
        this.digraph = digraph;
        return this.getDistance();
    }

    private Integer getDistance() {
        Integer distance = 0;
        String[] nodeArr = route.split("");
        for (int i = 1, len = nodeArr.length; i < len; i++) {
            String edge = nodeArr[i - 1] + nodeArr[i];
            Optional<Edge> edgeOptional = this.findEdge(edge);
            if (edgeOptional.isPresent()) {
                distance += edgeOptional.get().getDistance();
            } else {
                return NO_SUCH_ROUTE;
            }
        }
        return distance;
    }

    private Optional<Edge> findEdge(String route) {
        Optional<Edge> edgeOptional = this.digraph.getEdges()
                .stream()
                .filter(o -> o.getName().equals(route))
                .findFirst();
        return edgeOptional;
    }
}
