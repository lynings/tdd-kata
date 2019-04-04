package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class Edge {

    private String origin;
    private String destination;
    private Integer distance;

    public Edge(String origin, String destination, Integer distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getDistance() {
        return distance;
    }
}
