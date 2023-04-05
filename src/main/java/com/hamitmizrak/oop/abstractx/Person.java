package com.hamitmizrak.oop.abstractx;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
abstract public class Person {
    private long id;
    private String username;
    private String surname;

    public void deneme(String name){
        System.out.println(name);
    }

   abstract public void govdesizMethod(int number);
}
