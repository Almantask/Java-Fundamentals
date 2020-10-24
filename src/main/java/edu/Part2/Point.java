package edu.Part2;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceTo(Point p2){
        double distance = Math.sqrt((p2.x-x)*(p2.x-x) + (p2.y - y)*(p2.y - y));
        return distance;
    }

}
