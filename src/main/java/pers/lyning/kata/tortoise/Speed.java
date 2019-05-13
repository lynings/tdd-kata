package pers.lyning.kata.tortoise;

/**
 * @author lyning
 */
class Speed {
    private final double avgOfSeconds;
    private double feet;

    private Speed(double feet, double feetLead) {
        this.feet = feetLead;
        this.avgOfSeconds = this.avgOfSeconds(feet);
    }

    public boolean catchTo(Speed speed) {
        return this.feet >= speed.feet;
    }

    public static Speed init(double feet, double feetLead) {
        return new Speed(feet, feetLead);
    }

    public Speed nextSeconds() {
        this.feet += this.avgOfSeconds;
        return this;
    }

    private double avgOfSeconds(double feet) {
        return feet / 3600;
    }
}
