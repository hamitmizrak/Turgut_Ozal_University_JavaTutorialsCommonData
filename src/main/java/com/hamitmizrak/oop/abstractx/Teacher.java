package com.hamitmizrak.oop.abstractx;


public class Teacher  extends Person {
    @Override
    public void deneme(String name) {
        super.deneme(name);
    }

    @Override
    public void govdesizMethod(int number) {
        System.out.println("Teacher: "+number);
    }
}
