package com.hamitmizrak.oop.abstractx;

public class Student extends Person {
    @Override
    public void deneme(String name) {
        super.deneme(name);
    }

    @Override
    public void govdesizMethod(int number) {
        System.out.println("Student: "+number);
    }
}
