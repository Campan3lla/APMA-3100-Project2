package edu.virginia.apma;

public class Coordinate {
    private final double x, y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getXCoordinate() {
        return x;
    }

    public double getYCoordinate() {
        return y;
    }

    public static double getDistance(Coordinate coordinate1, Coordinate coordinate2) {
        double sqXDif = Math.pow(coordinate2.x - coordinate1.x, 2);
        double sqYDif = Math.pow(coordinate2.y - coordinate1.y, 2);
        return Math.sqrt(sqXDif + sqYDif);
    }
}
