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

    /**
     * increase brightness by 1
     *
     * @param score
     */
    public void turnOn(Score score) {
        Position start = score.getStart();
        Position end = score.getEnd();
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                lightsMatrix[x][y] += 1;
            }
        }
    }

    /**
     * decrease brightness by 1, minimum of zero
     *
     * @param score
     */
    public void turnOff(Score score) {
        Position start = score.getStart();
        Position end = score.getEnd();
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                if (lightsMatrix[x][y] > 0) {
                    lightsMatrix[x][y] -= 1;
                }
            }
        }
    }

    /**
     * increase brightness by 2
     *
     * @param score
     */
    public void toggle(Score score) {
        Position start = score.getStart();
        Position end = score.getEnd();
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                lightsMatrix[x][y] += 2;
            }
        }
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
                totalBrightness += lightsMatrix[x][y];
            }
        }
        return totalBrightness;
    }
}
