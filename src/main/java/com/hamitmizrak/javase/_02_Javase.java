package com.hamitmizrak.javase;

public class _02_Javase {
    //Method
    public static void voidliParametresiz() {
        System.out.println("voidli Parametresiz");
    }

    public static void voidliParametreli(String name) {
        System.out.println("voidli Parametreli " + name);
    }


    public static String voidsizParametresiz() {
        return "voidsiz Parametresiz";
    }

    public static String voidsizParametreli(int number) {
        return "voidsiz Parametreli " + number;
    }

    //PSVM
    public static void main(String[] args) {
        voidliParametresiz();
        voidliParametreli("data");
        String changeData1 = voidsizParametresiz();
        System.out.println(changeData1);
        String changeData2 = voidsizParametreli(44);
        System.out.println(changeData2);

    }

}
