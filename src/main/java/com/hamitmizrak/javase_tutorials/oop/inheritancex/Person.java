package com.hamitmizrak.javase_tutorials.oop.inheritancex;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private long id;
    private String username;
    private String surname;

    public void deneme(String name){
        System.out.println(name);
    }
}
