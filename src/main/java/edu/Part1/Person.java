package edu.Part1;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    public static int CreatedPeopleCount = 0;

    public String Name;
    public LocalDate Birthday;
    public float Weight;
    public float Height;

    // Newborn
    public Person(String name, float weight, float height){
        if(name == null || name.isEmpty()){
            // ...
        }
        Name = name;
        Birthday = LocalDate.now();
        Weight = weight;
        Height = height;
    }

    // Already existing person
    public Person(String name, float weight, float height, LocalDate birthday){
        Name = name;
        Weight = weight;
        Height = height;
        Birthday = birthday;
    }

    public int getAge(){
        return Period.between(Birthday, LocalDate.now()).getYears();
    }
}
