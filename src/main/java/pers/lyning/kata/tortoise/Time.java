package pers.lyning.kata.tortoise;

/**
 * @author lyning
 */
public class Time {
    private int value;

    private Time(int value) {
        this.value = value;
    }

    public static Time second(int second) {
        return new Time(second);
    }

    public int years() {
        return value / 3600;
    }

    public int minutes() {
        return this.value / 60 % 60;
    }

    public int seconds() {
        return this.value % 60;
    }

    public void increase(int value) {
        this.value += value;
    }
}
