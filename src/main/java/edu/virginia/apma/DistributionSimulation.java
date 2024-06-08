package edu.virginia.apma;

import java.util.ArrayList;
import java.util.List;

public class DistributionSimulation {
    private final Distribution randomVariable;

    public DistributionSimulation(Distribution randomVariable) {
        this.randomVariable = randomVariable;
    }

    public List<ExcelWritable> generateExcelWritableRealizations(int number) {
        return new ArrayList<>(generateRealizations(number));
    }

    public List<Realization> generateRealizations(int number) {
        List<Realization> realizations = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Realization currentRealization = getRealization();
            realizations.add(currentRealization);
        }
        return realizations;
    }

    public Realization getRealization() {
        double probability = RandomNumber.getRandomNumber();
        double realization = randomVariable.getInverseCDFValue(probability);
        Realization newRealization = new Realization(realization, probability);
        newRealization.setValueIdentifier("CDF Probability: ");
        return newRealization;
    }

    public double getSampleMean(List<Realization> realizations) {
        return realizations.stream()
                .mapToDouble(Realization::getRealization)
                .sum() / realizations.size();
    }
}
