package edu;

import java.time.LocalDate;
import java.time.Period;

public class Person2 {
    public static int CreatedPeopleCount = 0;

    public static String Name = "Tom";
    public LocalDate Birthday;
    public float Weight;
    public float Height;

    // Newborn
    public Person2(float weight, float height){
        Birthday = LocalDate.now();
        Weight = weight;
        Height = height;
    }

    // Already existing person
    public Person2(String name, float weight, float height, LocalDate birthday){
        Person2.Name = name;
        Weight = weight;
        Height = height;
        Birthday = birthday;
    }

    public int getAge(){
        return Period.between(Birthday, LocalDate.now()).getYears();
    }
}
