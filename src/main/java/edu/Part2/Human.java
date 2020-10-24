package edu.Part2;

// Can talk using lips
// Can walk using legs
// Can grab something using hand
// Human has a name
public class Human {
    private final String name;
    private Point position;

    private Head head;
    private Hand handLeft;
    private Hand handRight;
    private Leg legLeft;
    private Leg legRight;

    public Human(
            String name,
            Point position,
            Head head,
            Hand handLeft,
            Hand handRight,
            Leg legLeft,
            Leg legRight) {
        this.name = name;
        this.head = head;
        this.handLeft = handLeft;
        this.handRight = handRight;
        this.legLeft = legLeft;
        this.legRight = legRight;
        this.position = position;

        System.out.println("It's alive!");
    }

    public void Talk(String words){
        head.talk(words);
    }

    public void Walk(Point pointTo){
        double distance = position.distanceTo(pointTo);
        simulateWalking(distance);

        handLeft.swing();
        handRight.swing();

        position = pointTo;
    }

    public void Grab(Object target){
        handLeft.setHolding(target);
        handRight.setHolding(target);
    }

    private void simulateWalking(double distance) {
        int steps = (int)Math.ceil(distance);
        boolean isLeft = true;
        for(int i = 0; i < steps; i++){
            if(isLeft){
                legLeft.step();
            }
            else{
                legRight.step();
            }
            isLeft = !isLeft;
        }
    }
}
