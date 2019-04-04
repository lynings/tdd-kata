package pers.lyning.kata.trains;

/**
 * @author lyning
 */
public class Route {
    private String origin;
    private String destination;

    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public boolean isArrivedToDestination(String route) {
        if (route.startsWith(this.getOrigin()) && route.endsWith(this.getDestination())) {
            return true;
        }
        return false;
    }
}
