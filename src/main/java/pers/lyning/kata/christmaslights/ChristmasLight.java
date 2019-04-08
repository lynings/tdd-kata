package pers.lyning.kata.christmaslights;


/**
 * @author lyning
 */
public class ChristmasLight {

    /**
     * 圣诞灯矩阵
     */
    private Integer[][] lightsMatrix = new Integer[3][3];

    public void turnOn(Score score) {
        Position start = score.getStart();
        Position end = score.getEnd();
        for (int x = start.getX(); x <= end.getX(); x++) {
            for (int y = start.getY(); y <= end.getY(); y++) {
                lightsMatrix[x][y] = 1;
            }
        }
    }

    public Integer getLights() {
        Integer numberOfOnLights = 0;
        for (int x = 0; x < lightsMatrix.length; x++) {
            for (int y = 0; y < lightsMatrix[x].length; y++) {
                if (lightsMatrix[x][y] > 0) {
                    numberOfOnLights += 1;
                }
            }
        }
        return numberOfOnLights;
    }
}
