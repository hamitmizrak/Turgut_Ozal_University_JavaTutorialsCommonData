package com.hamitmizrak.javase;

import java.util.Random;
import java.util.Scanner;

public class _01_Javase {
    public static void main(String[] args) {
        String $_variableData44="Merhabalar";
        System.out.println($_variableData44);

        //S1
        // 1.soru
        // 1.dereceden 2 bilinmeyenli denklem
        // y=3x+4k;
        // x=5;
        // k=3

        //S2
        // 2.soru
        // Dereceyi Fahrenhayt
        // (derece*9/5)+32
        // 0 derece 32 fahrenhayttır

        /*Scanner klavye=new Scanner(System.in);
        System.out.println("Lütfen bir kelime giriniz");
        String data=klavye.nextLine();
        System.err.println(data);*/

        //sayıyı String'e çevirmek
        int number=44;
        String str1=String.valueOf(number); //object
        String str2=Integer.toString(number);

        // String'i  sayıya çevirmek
        String str3="44";
        int number2=Integer.valueOf(str3);
        int number3=Integer.parseInt(str3);
        //Escape character \
        System.out.println("1.satır");
        System.out.println("2.satır");
        System.out.println("3.satır\n4.satır");

        ///MATH
        System.out.println(Math.min(3,-100));
        System.out.println(Math.max(3,-100));
        System.out.println(Math.pow(2,5));
        System.out.println(Math.abs(-100));
        System.out.println(Math.sqrt(Math.abs(-100)));
        System.out.println(Math.floor(4.9));
        System.out.println(Math.ceil(4.1));
        System.out.println(Math.round(6.4));
        System.out.println(Math.round(6.5));
        System.out.println(Math.sin(45));

        //Rastgele
        System.out.println(Math.floor(Math.random()*10+1));
        Random random=new Random();
        int number8=random.nextInt(10)+1;
        System.out.println(number8);






    }
}
