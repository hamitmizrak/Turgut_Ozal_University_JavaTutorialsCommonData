package com.hamitmizrak.javase_tutorials;

import java.util.*;

public class _06_javase {
    //Loop
    public static void loopFor() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }

    public static void loopWhile() {
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
    }

    public static void loopDoWhile() {
        int i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= 10);
    }

    //Debug
    //Exception handling
    public static void exceptionHandling() {
        System.out.println("ilk data");
        try {
            int i = 4 / 0;
        } catch (ArithmeticException ai) {
            //System.out.println(e);
            ai.printStackTrace();
        } catch (Exception e) {
            //System.out.println(e);
            e.printStackTrace();
        }

        System.out.println("son data");
    }

    //Array:eleman sayısı belli olanlarda
    public static void arrayTutorials() {
        int[] arr = new int[4];
        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 4;
        System.out.println(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        Arrays.sort(arr);

        for (int temp : arr) {
            System.out.print(temp + " ");
        }
    }

    //Collection:eleman sayısı belli olmayanlar
    public static void collectionTutorials1() {
        //Liste => LAV (linkedList, ArrayList, Vector)
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);

        for (Integer temp : list) {
            System.out.println(temp + " ");
        }
        System.out.println("");

       /* for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("");

        for( Integer temp: list){
            System.out.println(temp+" ");
        }
        System.out.println("");

        list.stream().forEach(System.out::println);
        System.out.println("");

        Collections.sort(list);
        list.stream().forEach((temp)->{
            System.out.println(temp);
        });*/
    }

    public static void collectionTutorials2() {
        //Küme => HalaT
        //Liste => LAV (linkedList, ArrayList, Vector)
        Set<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(10);
        integerSet.add(10);
        integerSet.add(30);
        integerSet.add(20);
        integerSet.add(40);

        for (Integer temp : integerSet) {
            System.out.println(temp + " ");
        }
    }

    public static void collectionTutorials3() {
        //Map
        Map<String, Object> mapList = new TreeMap<>();
        mapList.put(UUID.randomUUID().toString(), "Malatya");
        mapList.put(UUID.randomUUID().toString(), "Elazığ");

        for (String temp : mapList.keySet()) {
            System.out.println(temp + " => " + mapList.get(temp));
        }
    }

    public static void collectionTutorials4() {
        //1-9 arasında rastgele 5 tane sayı oluşturulsun bu sayıların toplamını veren algoritma
        int[] arr = new int[5];
        Random random = new Random();
        int sum=0;
        //Çift olanlardan kaçtane ?
        //çift olanların toplamı ?
        //tek olanlardan kaçtane ?
        //tek olanların toplamı ?

        for (int i = 0; i < arr.length; i++) {
            int temp = random.nextInt(9)+1;
            arr[i]=temp;
            sum+=arr[i];
        }

        for (int temp: arr) {
            System.out.print(temp+" ");
        }
        System.out.println("TOPLAM => "+sum);

    }

    public static void main(String[] args) {
        //loopFor();
        //System.out.println();
        //loopWhile();
        //System.out.println();
        //loopDoWhile();
        //exceptionHandling();
        //arrayTutorials();
        /*collectionTutorials1();
        System.out.println();
        collectionTutorials2();*/
        //collectionTutorials3();

        collectionTutorials4();
    }
}
