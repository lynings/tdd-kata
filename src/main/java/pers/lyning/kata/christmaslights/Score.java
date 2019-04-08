package pers.lyning.kata.christmaslights;

/**
 * @author lyning
 */
public class Score {

    private Position start;

    private Position end;

    private Score() {
    }

    public Score start(int x, int y) {
        this.start = new Position(x, y);
        return this;
    }

    public Score end(int x, int y) {
        this.end = new Position(x, y);
        return this;
    }

    public static Score create() {
        return new Score();
    }

    public Position getStart() {
        return this.start;
    }

    public Position getEnd() {
        return this.end;
    }
}
