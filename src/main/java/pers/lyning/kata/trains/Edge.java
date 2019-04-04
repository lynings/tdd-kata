package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class Edge {

    private String startNode;
    private String endNode;
    private Integer distance;

    public Edge(String startNode, String endNode, Integer distance) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.distance = distance;
    }

    public String getStartNode() {
        return startNode;
    }

    public String getEndNode() {
        return endNode;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getName() {
        return this.getStartNode() + this.getEndNode();
    }
}
