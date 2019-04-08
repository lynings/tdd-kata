package pers.lyning.kata.christmaslights;


/**
 * README link /Users/mac/Code/TDD/tdd-kata/src/main/resources/christmaslights/README.md
 *
 * @author lyning
 */
public class ChristmasLight {

    /**
     * 圣诞灯矩阵
     */
    private int[][] lightsMatrix = new int[1000][1000];
    private final int TOGGLE_INCREASE_BRIGHTNESS = 2;
    private final int TURN_ON_INCREASE_BRIGHTNESS = 1;
    private final int TURN_OFF_DECREASE_BRIGHTNESS = -1;

    /**
     * increase brightness by 1
     *
     * @param score
     */
    public void turnOn(Score score) {
        increaseBrightness(score, TURN_ON_INCREASE_BRIGHTNESS);
    }

    /**
     * decrease brightness by 1, minimum of zero
     *
     * @param score
     */
    public void turnOff(Score score) {
        decreaseBrightness(score, TURN_OFF_DECREASE_BRIGHTNESS);
    }

    /**
     * increase brightness by 2
     *
     * @param score
     */
    public void toggle(Score score) {
        this.increaseBrightness(score, TOGGLE_INCREASE_BRIGHTNESS);
    }

    private void increaseBrightness(Score score, int brightness) {
        Position start = score.getStart();
        Position end = score.getEnd();
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                lightsMatrix[x][y] += brightness;
            }
        }
    }

    private void decreaseBrightness(Score score, int brightness) {
        increaseBrightness(score, brightness);
    }

    public int getLights() {
        int numberOfOnLights = 0;
        for (int x = 0; x < lightsMatrix.length; x++) {
            for (int y = 0; y < lightsMatrix[x].length; y++) {
                if (lightsMatrix[x][y] > 0) {
                    numberOfOnLights += 1;
                }
            }
        }
        return numberOfOnLights;
    }

    public int totalBrightness() {
        int totalBrightness = 0;
        for (int x = 0; x < lightsMatrix.length; x++) {
            for (int y = 0; y < lightsMatrix[x].length; y++) {
                if (lightsMatrix[x][y] > 0) {
                    totalBrightness += lightsMatrix[x][y];
                }
            }
        }
        return totalBrightness;
    }
}
