package edu.Test1;

public class Square {
    private float width;
    private float height;

    public Square(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float space(){
        return height * width;
    }
}
