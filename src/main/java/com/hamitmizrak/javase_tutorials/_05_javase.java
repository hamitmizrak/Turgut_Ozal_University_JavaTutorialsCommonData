package com.hamitmizrak.javase_tutorials;

public class _05_javase {
    //conditional

    public static void conditional() {
        //Scanner: Kullanıcıdan alınan sayıya göre negatif pozitif veren algoritma yazınız ?
        int number = 5;
        if (number > 0) {
            System.out.println("pozitif");
        } else
            System.out.println("negatif");
    }


    public static void conditional2() {
        int number = 5;
        String result = (number > 0) ? "pozitif" : "negatif";
        System.out.println(result);
    }

    public static void conditional3() {
        int number = 5;
        if (number == 1) {
            System.out.println("1");
        } else if (number == 2)
            System.out.println("2");
        else if (number == 3)
            System.out.println("3");
        else if (number == 4)
            System.out.println("4");
        else if (number == 5)
            System.out.println("5");
        else
            System.out.println("farklı bir sayıdır");
    }

    public static void conditional4() {
        int number = 5;
        switch (number) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            default:
                System.out.println("farklı bir sayıdır");
                break;
        }
    }

    public static void main(String[] args) {
        conditional();
        conditional2();
        conditional3();
        conditional4();
    }

    /*
    VKI: Kullanıcıdan öncelikle Bayan mı Erkek mi oludğunu öğrenceksiniz ?
    klavye.nextLine();
    Kadınlar için ideal kilo formülü:
    Kadınlar için ideal kilo hesaplama formülü  45,5 + 2,3 x ( (Boy(cm)/2,54) – 60)

    Erkekler için ideal kilo formülü:
    Erkekler için ideal kilo hesaplama formülü  50 + 2,3 X ( (Boy(cm)/2,54) – 60)
    */

    /*
    Kullanıcıdan aldığımız password ile kullanıcadn aldığımız repassword verisi birbirine eşit mi değil mi ?
   */

}
