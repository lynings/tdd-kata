package pers.lyning.kata.tortoise;

/**
 * @author lyning
 */
class Speed {
    private double feet;
    private final double avgOfSeconds;

    private Speed(double feet, double feetLead) {
        this.feet = feetLead;
        this.avgOfSeconds = this.avgOfSeconds(feet);
    }

    public static Speed init(double feet, double feetLead) {
        return new Speed(feet, feetLead);
    }

    public Speed nextSeconds() {
        this.feet += this.avgOfSeconds;
        return this;
    }

    public boolean catchTo(Speed speed) {
        return this.feet >= speed.feet;
    }

    private double avgOfSeconds(double feet) {
        return feet / 3600;
    }
}
