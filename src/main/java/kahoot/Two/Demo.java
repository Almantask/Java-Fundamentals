package kahoot.Two;

public class Demo {
    public static void main(String[] args) {
        EmotionalState state1 = new EmotionalState("Ok");
        EmotionalState state2 = new EmotionalState("Confused");

        // What will this print?
        System.out.printf("s1 = %s, s2 = %s", state1, state2);
    }
}
