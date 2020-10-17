package kahoot;

public class Referencs {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        boolean result = a && b;
        boolean inverted1= !a && !b;
        boolean inverted2= !result;
        System.out.println("inverted =" + inverted1 + " inverted2 =" + inverted2);
        }
    }
