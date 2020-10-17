package homework;

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        // 2. Find indeces of all numbers to be searched in an array
        int[] numbers = {1,4,2,1,6,3,1};
        Scanner values = new Scanner(System.in);
        int v = values.nextInt();
        int [] indexes = find(numbers, v);
        print(indexes);
    }

    private static int [] find(int[] numbers, int toFind) {
        int[] result = new int[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == toFind) {
                // for example: found :3
                // before: {0, 1}
                result = add(result, i);
                // after: {0, 1, 3}
            }
        }
        return result;
    }
    private static int[] add(int [] numbers, int toAdd){
        // numbers = {0, 1}
        int [] numbersBigger = new int[numbers.length+1];
        // numbersBigger = {0, 0, 0}
        for (int i = 0; i<numbers.length;i++){
            numbersBigger [i] = numbers[i];
        }
        // numbersBigger = {0, 1, 0}

        numbersBigger[numbers.length]=toAdd;
        // numbers = {0, 1 ,3}
        return numbersBigger;
    }
    private static void print(int[] indexes) {
        for (int i = 0; i< indexes.length; i++){
            System.out.println(indexes[i]);
        }
    }
}