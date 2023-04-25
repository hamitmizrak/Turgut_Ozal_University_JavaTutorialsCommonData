package com.hamitmizrak.javase_tutorials.paralel;

// 1- Extends (Kalıtım)
// Javada sadece 1 tane extends hakkınız vardır.
public class _01_Thread_Extends_Implements_Anonymous extends Thread {
    @Override
    public void run() {
        //Codes
    }
}

// 2- Implements (interface)
// istediğimiz kadar implements verebiliriz.
class ImplementsClass implements Runnable{
    @Override
    public void run() {
        //Codes
    }
}

// 3- Anonymous ==> metotla çözmek
class AnonymousClass {
   public void anonymousMethod(){
       Thread thread=new Thread(new Runnable() {
           @Override
           public void run() {

           }
       });
   }
}
