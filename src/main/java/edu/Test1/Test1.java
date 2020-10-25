package edu.Test1;

public class Test1 {
    public static void main(String[] args) {
        // assignment
        // static state - global

        Pen pen1 = new Pen(true);
        Pen pen2 = new Pen(false);

        System.out.printf("%s %s", pen1.isClicked(), pen2.isClicked());
        System.out.println();

        Pen.whatIsThis();
        System.out.println(Pen.BRAND);
        Square square1 = new Square(10, 10);
        Square square2 = new Square(5, 9);
        float space11 = square1.space();
        float space12 = ShapeCalculator.space(square1);

        float space12 = square2.space();


        Calculator.calculateSpace(square);




        demoVarArgs();
        // when to write int and when to write Integer?
        // - when the value can be unknown- write Integer.
        // else write int.
        String s = new String("");
        Woman woman = new Woman(29, 175, null);
    }

    private static void demoVarArgs() {
        int[] numbers = {1,2,3,4};

        int sum1 = sum1(numbers);
        System.out.println(sum1);

        int sum2 = sum2(1,2,3,4);
        System.out.println(sum2);

        int sum3 = sum2();
        System.out.println(sum3);

        int sum4 = sum2(1);
        System.out.println(sum4);
    }

    private static int sum1(int[] numbers){
        int total = 0;
        for (int number :
                numbers) {
            total+= number;
        }

        return total;
    }

    private static int sum2(int ... numbers){
        int total = 0;
        for (int number :
                numbers) {
            total+= number;
        }

        return total;
    }
}
