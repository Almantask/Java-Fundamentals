package edu.Test1;

public class Pen {
    public final static String BRAND = "LT";
    private boolean clicked;

    public Pen(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isClicked() {
        return clicked;
    }
    public void click(boolean clicked) {
        this.clicked = clicked;
    }

    public static void whatIsThis(){
        System.out.println("It's a pen " + BRAND);
    }
}
