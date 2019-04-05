package pers.lyning.kata.trains.strategy;

import pers.lyning.kata.trains.Digraph;
import pers.lyning.kata.trains.Edge;

import java.util.Optional;

/**
 * 用于计算从起点到终点存在的单一可行路线
 *
 * @author lyning
 */
public class SingleRouteDistanceCalculationStrategy implements CalculationStrategy {

    private Digraph digraph;
    private String route;

    public SingleRouteDistanceCalculationStrategy(String route) {
        this.route = route;
    }

    @Override
    public Integer execute(Digraph digraph) throws Exception {
        this.digraph = digraph;
        return this.getDistance();
    }

    private Integer getDistance() throws Exception {
        Integer distance = 0;
        String[] nodeArr = route.split("");
        for (int i = 1, len = nodeArr.length; i < len; i++) {
            String edge = nodeArr[i - 1] + nodeArr[i];
            Optional<Edge> edgeOptional = this.findEdge(edge);
            if (edgeOptional.isPresent()) {
                distance += edgeOptional.get().getDistance();
            }
        }

        if (distance == 0) {
            throw new Exception("NO SUCH ROUTE");
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
