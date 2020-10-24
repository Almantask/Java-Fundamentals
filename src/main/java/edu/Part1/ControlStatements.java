package edu.Part1;

public class ControlStatements {
    public static void demo(){
        demoForeach();
        demoWhile();
        demoContinueAndBreak();
        // Find index of a the number searched
        // Return -1 if not found.
        // For example:
        // int[] numbers = {1,2,5,18};
        // int index = find(numbers, 5);
        // output: 2.
        // int index = find(numbers, 3);
        // output: -1.
    }

    private static void demoContinueAndBreak() {
        System.out.println();
        System.out.println("odd numbers: ");
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0){
                continue;
            }

            System.out.print(i + " ");
        }

        System.out.println();
        // the same
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0){
                if(i%3==0 && i > 0){
                    break;
                }
                continue;
            }

            System.out.print(i + " ");
        }

        System.out.println();
        // the same
        for(int i = 1; i < 6; i+=2){
            System.out.print(i + " ");
        }

        System.out.println();
        for(int i = 1; i < 6; i++){
            if(i % 2 == 1){
                System.out.print(i + " ");
            }
        }
    }


    private static void demoWhile() {
//        boolean workerCanWork = true;
//        while(workerCanWork){
//            boosArround();
//            //workerCanWork = isTired && workHoursOver;
//        }
    }

    private static void boosArround() {
        System.out.println("Work...");
    }

    private static void demoForeach() {
        int[] numbers = {1,2,3};
        for (int number :
                numbers) {
            System.out.print(++number);
        }

        for (int number :
                numbers) {
            System.out.print(number);
        }
    }

    private static void demoArrayInitialization() {
        // classical
        int[] a = new int[2];
        a[0] = 10;
        a[1] = 5;

        // object initializer 1
        int[] b = new int[]{1,2};

        // object initializer 2
        // least verbose
        int[] c = {1,2,3};
    }

    // Applies to: boolean, byte, short, int, long, float, double, char, string.
    private static void passReferenceDemo() {
        // Created a new reference (pointer)
        int[] one = new int[1];
        one[0] = 1;
        passReference(one);
        System.out.println("Outside function one[0] = " + one[0]);
    }

    private static void passValueDemo() {
        int a = 1;
        a = passValue(a);
        //passValue(a);
        System.out.println("Outside function a = " + a);
    }

    // We always work with a copy
    // In this case, a copy of a REFERENCE
    // Applies to all the rest :D
    private static void passReference(int[] one){
        // New references
        int[] other = new int[1];
        // If you want to create a DIFFERENT HOUSE that LOOKS EXACTLY THE SAME (same rooms, etc)
        // You need to take the original and set the same indexes to have the same values.
        for (int i = 0; i < one.length; i++)
        {
            other[i] = one[i];
        }

        one[0] = 5;
        System.out.println("Inside function one[0] = " + one[0]);
    }

    // We always work with a copy
    // copy of a value is the same value but a different argument
    private static int passValue(int a){
        a = 5;
        System.out.println("Inside function a = " + a);

        return a;
    }

    private static void printBiggerOfTwo(int a, int b) {
        // First condition
        if(a > b){
            System.out.println(a);
        }
        // Second, third, fourth and so on... condition
        else if(b > a){
            System.out.println(b);
        }
        // If neither condition is true
        else{
            System.out.println("a = b");
        }
    }

    private static void printIfToggled(boolean toggled) {
        // no need toggled == true because it is already true or false
        if(toggled){
            System.out.println("toggled");
        }
    }

    private static void printNumber(int i) {
        switch(i){
            // if i == 0
            case 0 :
                System.out.println("Zero");
                // Break is used not to evaluate other branches
                break;
            // else if i == 1
            case 1:
                System.out.println("One");
                break;
            // else
            default:
                System.out.println("Unrecognized");
        }
    }

    private static int[] buildNumbers(){
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 4;

        return numbers;
    }

    private static void demoPass(int[] numbers) {
        System.out.println("Before:");
        // [1,4,0,0,0]
        printUsingFor(numbers);

        passArray(numbers);

        // [1,4,3,0,5]
        System.out.println("After:");
        printUsingFor(numbers);
    }

    private static void passArray(int[] numbers) {
        numbers[2] = 3;
        numbers[4] = 5;
    }


    /**
     * Uncomment each block of code to see a different error
     */
    private static void showcaseArrayErrors(){
        // OutOfMemoryError
        //int[] numbersTooBig = new int[Integer.MAX_VALUE];

        // ArrayIndexOutOfBoundsException
        //int[] numbersEmpty = new int[0];
        //int first1 = numbersEmpty[0];

        // NullPointerException
        int[] numbersNull = null;
        int first2 = numbersNull[0];
    }

    private static void doNothingWithPlaceboLoop() {
        // A weird, useless loop.
        // Syntactically valid though...
        for(int i = 0; i < 10; i++);
    }

    private static void print(int[] numbers) {
        printUsingFor(numbers);
        printUsingForEach(numbers);
        printUsingWhile(numbers);
        printUsingDoWhile(numbers);
    }

    private static void demoPause(int[] numbers){
        // Avoid such loop condition.
        // Request to continue explicitly
        int i = 0;
        while(true){
            if(i == 0){
                // jump to next iteration.
                continue;
            }
            if(i == 1){
                System.out.println("Done");
                // stop the whole loop
                break;
            }
        }

        // stop the whole function. All that happens after (within the same scope) will be ignored.
        return;
        //System.out.println("This will never happen");
    }

    private static void reducingNesting(){
        for(int i = 0; i < 10; i++){
            doSomething(i);
        }
    }

    private static void initializeUsingObjectInitializer(){
        int[] numbersA = new int[]{1,2,3,4,5};
        int[] numbersB = {1,2,3,4,5};
    }

    private static void demoStringRelationToChar(){
        String greet = "Hello!";
        char firstLetter = greet.charAt(0);
        System.out.println(firstLetter);
        // String is not an char[]
        // String has char[]
    }

    private static void doSomething(int i) {
        System.out.println(10-i);
        System.out.print("Something");
        System.out.print("Something more");
        System.out.println(i);
        // And more code
    }

    private static void printIfNotNull(int[] numbers){
        if(numbers == null) return;
        printUsingFor(numbers);
    }

    private static void printUsingFor(int[] numbers) {
        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }

    private static void printUsingForEach(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static void printUsingWhile(int[] numbers) {
        int i = 0;
        while(i < numbers.length){
            System.out.println(numbers[i]);
            i++;
        }
    }

    private static void printUsingDoWhile(int[] numbers) {
        int i = 0;
        do{
            System.out.println(numbers[i]);
            i++;
        }while(i < numbers.length);
    }
}
