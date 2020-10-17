package homework;

public class Arrays {
    // run Arrays.java abc blm
    public static void main(String[] args) {
        System.out.println("Cmd arguments:");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
        }
        System.out.println();

        // Write a program that given array:
        //{1,5,7,2,3,6,9,10,0,10,10,11,10,5,1,5,1,0,-5,-21,1,0,0,3,-3, 3, -20};
        //it finds the second smallest number.
        //Output: -20
        int[] numbers = {1,5,7,2,3,6,9,10,0,10,10,11,10,5,1,5,1,0,-5,-21,1,0,0,3,-3, 3, -20};
        twoLoops(numbers);
        sorted(numbers);
        sorted2(numbers);
        demoSortString();
    }

    private static void demoSortString() {
        String[] texts = {"A", "C", "B"};
        java.util.Arrays.sort(texts);
        for (int i = 0; i < texts.length; i++){
            System.out.print(texts[i]);
        }
    }

    private static void twoLoops(int[] numbers) {
        // Find smallest
        int smallest = numbers[0];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < smallest){
                smallest = numbers[i];
            }
        }

        // Find second smallest
        int secondSmallest = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > smallest && numbers[i] < secondSmallest){
                secondSmallest = numbers[i];
            }
        }

        System.out.println("Second smallest with sort: " + secondSmallest);
    }

    private static void sorted(int[] numbers) {
        // I am living in location A
        // I send my address to school => pass array to a function
        // My personal address and the address sent to school points to the same house

        // I moved out => new int[]
        // My school address is now out of date

        // working with a copy of a reference of numbers
        // original numbers ref 0x151454F4441F01 -> {1,2,3}
        // copy of numbers ref 0x151454F4441F01 -> {1,2,3}
        numbers[0] = 10;
        // original numbers ref 0x151454F4441F01 -> {10,2,3}
        // copy of numbers ref 0x151454F4441F01 -> {10,2,3}
        numbers = new int[3];
        // original numbers ref 0x151454F4441F01 -> {10,2,3}
        // copy of numbers ref 0x4F150999F411 -> {0,0,0}

        // 1, 0, 2
        for(int i = 0; i < numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++){
                int previous = numbers[i];
                int next = numbers[j];
                if(next < previous){
                    // swap next with previous
                    numbers[i] = next;
                    numbers[j] = previous;
                }
            }
        }

        System.out.println("Second smallest with sort: " + numbers[1]);
    }

    private static void sorted2(int[] numbers) {
        java.util.Arrays.sort(numbers);
        System.out.println("Second smallest with java sort: " + numbers[1]);
    }
}
