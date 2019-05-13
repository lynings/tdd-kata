package pers.lyning.kata.tortoise;

/**
 * @author lyning
 */
class Time {
    private int value;

    private Time(int value) {
        this.value = value;
    }

    public void increase(int value) {
        this.value += value;
    }

    public int minutes() {
        return this.value / 60 % 60;
    }

    public static Time second(int second) {
        return new Time(second);
    }

    public int seconds() {
        return this.value % 60;
    }

    public int years() {
        return this.value / 3600;
    }
}
