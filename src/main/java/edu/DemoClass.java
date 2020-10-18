package edu;

import java.time.LocalDate;

public class DemoClass {
    public static void run(){
        Person tom = new Person("Tom", 2.8f, 0.3f);
        // 1
        Person.CreatedPeopleCount++;
        Person bill = new Person("Bill", 84, 1.8f, LocalDate.of(1994, 2, 1));
        // 2
        Person.CreatedPeopleCount++;

        // 0
        System.out.println("Tom's age: " + tom.getAge());
        //  26
        System.out.println("Bill's age: " + bill.getAge());

        // ------
        Person2 tom1 = new Person2(1, 1);
        Person2 tom2 = new Person2(1, 1);
        Person2 tom3 = new Person2("James", 1, 1, LocalDate.now());

        tom2.Name = "Tom";
        System.out.println("tom2 = " + tom2.Name);
        tom2.Name = "Agnes";
    }
}
