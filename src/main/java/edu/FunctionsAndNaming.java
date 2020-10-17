package edu;

import java.util.Scanner;

public class FunctionsAndNaming {

    public static void demo(){
        printBartText();
        printBartText();
        printBartText();

        int sum = sum(5, 10);
        youDontSeeMe();
        scope();
        demoOutputAsArgument();
    }

    private static void demo2() {
        System.out.println(5+6);
        System.out.println(5-6);
        System.out.println(5*6);
        System.out.println(5/6);
        System.out.println(10+16);
        System.out.println(10-16);
        System.out.println(10*16);
        System.out.println(10/16);
        System.out.println(15+(16+1));
        System.out.println(15-(16+1));
        System.out.println(15*(16+1));
        System.out.println(15/(16+1));
    }

    private static void printBartText() {
        System.out.println("I will do my homework");
        System.out.println("I promise it will be done on time this time");
        System.out.println("I will not be late");
    }

    private static int sum(int a, int b){
        return a + b;
    }

    private static void youDontSeeMe(){
        // Return is optional.
        // Returns just means that the functions
        // returns back to the place it was called from.
        //return;
    }

    private static void scope() {
        {
            {
                {
                    {
                        {
                            System.out.println("Hey!");
                            int a = 5;
                        }
                        // Outer scope will not see inner scope
                        //System.out.println(a);
                    }
                }
            }
            //
        }
        {
            // Same level scope will not see what other scope has
        }
    }

    private static void demoOutputAsArgument() {
        System.out.println(getMyName());
    }

    private static void willNotExecute(){
        //return;
        //System.out.println("Huh?");
    }

    /**
     * What does it do?
     * This method does something.
     * @param a a is a parameter
     * @see Lesson2 for usage.
     */
    public static void DoSomething(int a) {
    }

    private static String getMyName(){
        return "Almantas";
    }

    private static void demoScopeReductionBad(String name, int age, float weight, float height){
        if(name != null && !name.isEmpty()){
            if(age > 0){
                if(weight > 0){
                    if(height > 0){
                        float bmi = weight / (height * height);
                        System.out.println(name + " has bmi = " + bmi);
                    }
                }
            }
        }
    }

    private static void demoScopeReductionGood(String name, int age, float weight, float height){
        if (name == null || name.isEmpty()) {
            return;
        }
        if (age <= 0) {
            return;
        }
        if (weight < 0 || weight > 1000) {
            return;
        }
        if (!(height > 0)) {
            return;
        }

        float bmi = weight / (height * height);
        System.out.println(name + " has bmi = " + bmi);
    }

    public static void writeWorkingStory(){
        printContents(0);
        printTitle("bla");
    }

    private static void writeCodingStory(){
        printTitle("The coding story");
        printContents(0);
        printChapter(0);
    }

    private static void printTitle(String the_coding_story) {
    }
    private static void printContents(int i) {
    }
    private static void printChapter(int i) {
        printSentence("Bla bla bla");
    }
    private static void printSentence(String bla_bla_bla) {
        printLetter('a');
    }
    private static void printLetter(char a) {
    }
}
