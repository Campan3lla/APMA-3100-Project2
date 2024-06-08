package edu.virginia.apma;

import java.util.ArrayList;
import java.util.List;

public class DeliverySimulation {
    private final DistributionSimulation randomVariable;

    public DeliverySimulation() {
        randomVariable = new DistributionSimulation(new RayleighDistribution((double) 1/57));
    }

    public List<ExcelWritable> generateExcelWritableRealizations(int  numberOfTrials, int numberOfTrialSequences) {
        return new ArrayList<>(generateSampleMeanRealizations(numberOfTrials, numberOfTrialSequences));
    }

    public List<Realization> generateSampleMeanRealizations(int numberOfTrials, int numberOfTrialSequences) {
        List<Realization> realizations = new ArrayList<>();
        for (int i = 0; i < numberOfTrialSequences; i++) {
            Realization currentRealization = getRealization(numberOfTrials);
            realizations.add(currentRealization);
        }
        return realizations;
    }

    private Realization getRealization(int number) {
        List<Realization> realizations = randomVariable.generateRealizations(number);
        double sampleMean = randomVariable.getSampleMean(realizations);
        Realization newRealization = new Realization(number, sampleMean);
        newRealization.setRealizationIdentifier("M" + number + ": ");
        return newRealization;
    }
}
