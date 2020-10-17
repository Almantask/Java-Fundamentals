package edu;

import java.math.BigDecimal;

public class PrimitiveTypes {
    public static void demo() {
        // This is a comment. Comment is marked in two ways. First one- with "//". Text after comment can be anything.
        /*
         * Second way to mark comment is this
         * */

        // Whole number: age, count, index
        // -2,147,483,648 to 2,147,483,647
        // int is most common, most compatible
        int lessIndex = 1;

        // Variations

        //
        byte dayOfWeek = 6;
        //

        short a = 0;
        // a = a + 1 = 1
        a++;
        // a = a - 1 = 0
        a--;
        // a = a + 3 = 3
        a+=3;
        // a = a - 2 = 1
        a-=2;
        // a = a / 2 = 0
        a/=2;
        // a = a * 2 = 0
        a*=2;

        a = 0;
        // prints 0.
        System.out.println(a++);
        a = 0;
        // prints 1.
        System.out.println(++a);

        // For money- always.
        BigDecimal money = new BigDecimal("15.6");
        System.out.println(money);

        printBooleanAlgebra();
    }

    private static void typeConversion(){
        double d1 = 100000000000000000000000000000000000000.000001;
        double d2 = 100000000000000000000000000000000000000.000001d;

        // Not supported
        // float f1 = 1000000000000000000000000000000000000000.000001;
        // Not supported
        // Cannot type with more precision to type with less precision.
        // float f2 = d1;
        float f3 = 100000000000000000000000000000000000000.000001f;
        float f4 = (float)100000000000000000000000000000000000000.000001;

        // When moving from bigger data type to smaller,
        // you need to EXPLICITLY CAST.
        float f5 = (float)d1;

        // When moving from smaller data type to bigger,
        // you can implicitly cast.
        // no risk
        double d3 = f5;
        // the same as above
        double d4 = (double)f5;

        // 0, -1, 5, 100, null.
        // Non-primitives support nulls
        Integer unknownAge = null;
        // Primitives do not support nulls
        //int unknownAge1 = null;

        // Math operations mostly work with doubles.
        // 5^2
        Math.pow(5,2);
    }

    private static void demoDiv(){
        System.out.println((float)(1/2));
    }

    private static void printBooleanAlgebra(){
        boolean t = true;
        boolean f = false;

        System.out.println("-----------------------------");
        System.out.println(t + " && " + f + "=" + (t&&f));
        System.out.println(t + " || " + f + "=" + (t||f));
        System.out.println(t + " && " + t + "=" + (t&&t));
        System.out.println(t + " || " + t + "=" + (t||t));
        System.out.println(f + " || " + f + "=" + (f||f));
        System.out.println(f + " && " + f + "=" + (f&&f));
        System.out.println("-----------------------------");

        System.out.println(t + " & " + f + "=" + (t&f));
        System.out.println(t + " | " + f + "=" + (t|f));
        System.out.println(t + " & " + t + "=" + (t&t));
        System.out.println(t + " | " + t + "=" + (t|t));
        System.out.println(f + " | " + f + "=" + (f|f));
        System.out.println(f + " & " + f + "=" + (f&f));
        System.out.println("-----------------------------");

        // All must be true
        // false && true && true && true... = false
        // At least one must be true
        // false || true || false || false || false = true

        boolean feature1Toggled = true;
        //..
        if(feature1Toggled){
            // AddFeature1Code();
        }
        String country = "USA";
        int age = 21;
        boolean isAllowedToDrink =
                (country == "USA" && age >= 21) ||
                (country != "USA" && age >= 18);

        // A: true || false = true
        // B: true || true && false = true && false = false
        // && - first
        // || - after
        boolean res1 = true && true || true && false;
        System.out.println("true && true || true && false="+ res1);

        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = true;
        boolean b4 = true;

        // true
        boolean res2 =
                checkValue(false) |
                checkValue(b1) |
                checkValue(b2) |
                checkValue(b3) |
                checkValue(b4);
        System.out.println();

        // true
        boolean res3 =
                checkValue(false) ||
                checkValue(b1) ||
                checkValue(b2) ||
                checkValue(b3) ||
                checkValue(b4);
        System.out.println();
    }

    private static boolean checkValue(boolean b){
        System.out.print(b);
        return b;
    }
}
