package edu.virginia.apma;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DeliverySimulation sim = new DeliverySimulation();
        List<ExcelWritable> simData = new ArrayList<>();

       /* List<Integer> trialNumbers = List.of(10, 30, 50, 100, 250, 500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000);
        for (Integer trial : trialNumbers) {
            List<ExcelWritable> writables = sim.generateExcelWritableRealizations(trial, 110);
            simData.addAll(writables);
        }*/
        List<Integer> sampleS5 = List.of(3, 9, 27, 81);
        List<Integer> estimatesS5 = List.of(5, 25, 110, 550);
        for (int i = 0; i < sampleS5.size(); i++) {
            List<ExcelWritable> writables = sim.generateExcelWritableRealizations(sampleS5.get(i), estimatesS5.get(i));
            simData.addAll(writables);
        }

        ExcelWriter writer = new ExcelWriter();
        writer.write(simData, "Se");

        /*System.out.println(RandomNumber.getRandomNumber(51));
        System.out.println(RandomNumber.getRandomNumber(52));
        System.out.println(RandomNumber.getRandomNumber(53));*/

    }
}
