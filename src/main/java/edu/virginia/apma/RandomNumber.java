package edu.virginia.apma;

public class RandomNumber {
    private static double startingSeed = 1000;
    private static double a = 24693;
    private static double c = 3967;
    private static double k = 262144;

    private static int currentTerm;
    private static int previousTerm;

    public static double getRandomNumber() {
        currentTerm++;
        if (currentTerm == 1) {
            previousTerm = getIntegerTerm(1);
        }
        else {
            previousTerm = (int)((a*previousTerm + c) % k);
        }
        return (double) previousTerm / k;
    }

    public static double getRandomNumber(int term) {
        return getIntegerTerm(term) / k;
    }

    protected static int getIntegerTerm(int term) {
        int currentTerm;
        if (term == 1)
            currentTerm = (int)((a*startingSeed + c) % k);
        else
            currentTerm = (int)((a*getIntegerTerm(term - 1) + c) % k);
        return currentTerm;
    }
}
