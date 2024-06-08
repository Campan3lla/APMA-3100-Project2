package edu.virginia.apma;

public interface Distribution {
    double getMean();
    double getVariance();
    double getPDFValue(double realization);
    double getCDFValue(double realization);
    double getInverseCDFValue(double probability);
}
