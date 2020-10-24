package edu.Part1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class String_ {
    public static void demo(){
        demoChar();
        minmax();
        //demoCompare();
        demoFormat();
        demoStringOperations();
    }

    private static void demoChar() {
        String me = "Me";
        System.out.println(me.charAt(0));
    }

    private static void demoStringOperations() {
        String hello = "Hello world";

        // From 0th to 5th character = Hello
        String firstWord = hello.substring(0, 5);
        // From 6th character till the end = world
        String secondWord = hello.substring(6);

        // 0
        int indexOfHell = hello.indexOf("Hell");
        // 1
        int indexOfe = hello.indexOf("e");

        String[] nameParts = {"A","l","m", "antas", };
        String name = String.join("", nameParts);
        // Prints Almantas
        System.out.println(name);

        String[] numbers = {"-1", "5", "0" };
        String numbersString = String.join(",", numbers);
        // Prints -1, 5, 0
        System.out.println(numbersString);

        System.out.println(numbers);

        String sentence = "Hello world! How are you?";
        String[] words = sentence.split(" ");
        System.out.println("Before split: " + sentence);
        System.out.print("After split: ");
        // After split: Hello
        // world!
        // How
        // are
        // you?
        for (String word :
                words) {
            System.out.println(word);
        }
        System.out.println();
    }

    private static void demoFormat() {
        String name = "Almantas";
        int age = 26;
        String role = "teacher";
        // Not like this
        String info1 = String.format(name + " is a " + role + " and is " + age + " years old.");
        // Like this
        String info2 = String.format("%s is a %s and is %s years old.", name, role, age);
        // Almantas is a teacher and is 26 years old.
        System.out.println(info2);


        double bigPositive = 100004678.14449977876545648979;
        double bigNegative = bigPositive * -1;
        int twenty = 20;

        // 20
        String wholeNumber= String.format("%d", twenty);
        // hex means a number in base 16 [0-F]
        // 012345789ABCDEF
        // decimal is a number in base 10 [0-1]
        // 20 = 2 * 10 + 0 = 20
        // 20 = 1 * 16 + 4 = 14
        String hex = String.format("%x", twenty);
        // 100004678.1445- rounded
        String floatingPoint = String.format("floatingPoint= %.4f", bigPositive);
        // 100004678
        String floatingPoint1 = String.format("floatingPoint1= %.0f", bigPositive);
        System.out.println(floatingPoint1);
        // 1.0000467814449978E8
        String scientificNotation = String.format("%e", bigPositive);
        // 100004678.14445977876545648979
        String stringified = String.format("%s", bigPositive);
        // 20
        String rightJustified = String.format("%10s", twenty);
        //         20
        String leftJustified = String.format("%-10s", twenty);
        // 100,004,678.14445977876545648979
        String withGroupingSeparator = String.format("%,f", bigPositive);
        // +100004678.14449977876545648979
        String withSignPositive = String.format("%+f", bigPositive);
        // -100004678.14449977876545648979
        String withSignNegative = String.format("%+f", bigNegative);

        String name1 = "Almantas";
        String greeting = "Hello," + name;

        String formattedName1 = String.format("Hello, %5s", name1);
        System.out.println(formattedName1);
        String name2= "Tomas";
        String formattedName2 = String.format("Hello, %5s", name2);
        System.out.println(formattedName2);

        // Environment.NewLine
        System.out.println("Hello\r\nWorld");
    }

    private static void demoCompare() {
        compareUserInput();
        compareConstants();
    }

    private static void compareUserInput() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        // Will not work regardless of "Java" being entered.
        if(input == "Java"){
            System.out.println("input == \"Java\"");
        }
        // Works as expected
        if(input.equals("Java")){
            System.out.println("input.equals(\"Java\")");
        }
        // Works as expected
        if(Objects.equals("Java", input)){
            System.out.println("Objects.equals(\"Java\", input)");
        }
    }

    private static void compareConstants() {
        String a3 = new String("a");
        String a5 = a3;
        String a4 = new String("a");

        String a1 = "a";
        String a2 = "a";

        boolean areEqual;
        // false, because different references
        areEqual = a3 == a4;
        // false, because different references
        areEqual = a3 == a1;
        // true, because both are the same value from string pool
        areEqual = a1 == a2;
        // true, because references are equal
        areEqual = a3 == a5;

        System.out.println("a3 == a4 -> " + (a3 == a4));
        System.out.println("a3 == a1 -> " + (a3 == a1));
        System.out.println("a1 == a2 -> " + (a1 == a2));
        System.out.println("a3 == a5 -> " + (a3 == a5));
    }

    private static void minmax() {
        char min = '\u0000';
        char max = '\uffff';

        System.out.println("min = " + min + " max = " + max);
    }

    private static void demoJoin(){
    }

    private static void demoSplit(){

    }
}
