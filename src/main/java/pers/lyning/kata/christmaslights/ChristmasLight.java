package pers.lyning.kata.christmaslights;


/**
 * @author lyning
 */
public class ChristmasLight {

    private final int TOGGLE_INCREASE_BRIGHTNESS = 2;
    private final int TURN_OFF_DECREASE_BRIGHTNESS = -1;
    private final int TURN_ON_INCREASE_BRIGHTNESS = 1;
    /**
     * 圣诞灯矩阵
     */
    private final int[][] lightsMatrix = new int[1000][1000];

    public int getLights() {
        int numberOfOnLights = 0;
        for (int x = 0; x < this.lightsMatrix.length; x++) {
            for (int y = 0; y < this.lightsMatrix[x].length; y++) {
                if (this.lightsMatrix[x][y] > 0) {
                    numberOfOnLights += 1;
                }
            }
        }
        return numberOfOnLights;
    }

    /**
     * increase brightness by 2
     *
     * @param score
     */
    public void toggle(Score score) {
        this.increaseBrightness(score, this.TOGGLE_INCREASE_BRIGHTNESS);
    }

    public int totalBrightness() {
        int totalBrightness = 0;
        for (int x = 0; x < this.lightsMatrix.length; x++) {
            for (int y = 0; y < this.lightsMatrix[x].length; y++) {
                if (this.lightsMatrix[x][y] > 0) {
                    totalBrightness += this.lightsMatrix[x][y];
                }
            }
        }
        return totalBrightness;
    }

    /**
     * decrease brightness by 1, minimum of zero
     *
     * @param score
     */
    public void turnOff(Score score) {
        this.decreaseBrightness(score, this.TURN_OFF_DECREASE_BRIGHTNESS);
    }

    /**
     * increase brightness by 1
     *
     * @param score
     */
    public void turnOn(Score score) {
        this.increaseBrightness(score, this.TURN_ON_INCREASE_BRIGHTNESS);
    }

    private void decreaseBrightness(Score score, int brightness) {
        this.increaseBrightness(score, brightness);
    }

    private void increaseBrightness(Score score, int brightness) {
        Position start = score.getStart();
        Position end = score.getEnd();
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                this.lightsMatrix[x][y] += brightness;
            }
        }
    }
}
