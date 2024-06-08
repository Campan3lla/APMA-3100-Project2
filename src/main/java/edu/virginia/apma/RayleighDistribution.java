package edu.virginia.apma;

public class RayleighDistribution implements Distribution {
    private final double alpha;

    public RayleighDistribution(double scaleParameter) {
        alpha = scaleParameter;
    }

    public double getMean() {
        return (1 / alpha) * Math.sqrt(Math.PI / 2);
    }

    public double getVariance() {
        return (4 - Math.PI) / (2 * Math.pow(alpha, 2));
    }

    public double getPDFValue(double realization) {
        double exponent = getExponent(realization);
        return Math.pow(alpha, 2) * realization * Math.pow(Math.E, exponent);
    }

    public double getCDFValue(double realization) {
        double exponent = getExponent(realization);
        return 1 - Math.pow(Math.E, exponent);
    }

    private double getExponent(double realization) {
        return -0.5 * Math.pow(alpha, 2) * Math.pow(realization, 2);
    }

    public double getInverseCDFValue(double probability) {
        double coefficient = -2/Math.pow(alpha, 2);
        return Math.sqrt(coefficient * Math.log(1 - probability));
    }
}
