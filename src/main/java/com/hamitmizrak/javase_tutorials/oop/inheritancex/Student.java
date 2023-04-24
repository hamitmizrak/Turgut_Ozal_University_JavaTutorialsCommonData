package com.hamitmizrak.javase_tutorials.oop.inheritancex;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student extends  Person{
    //global variable
    private String unicodeCharacter;

    public Student(long id, String username, String surname, String unicodeCharacter) {
        super(id, username, surname);
        this.unicodeCharacter = unicodeCharacter;
    }

    @Override
    public void deneme(String name) {
        super.deneme(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "unicodeCharacter='" + unicodeCharacter + '\'' +
                "} " + super.toString();
    }
}
