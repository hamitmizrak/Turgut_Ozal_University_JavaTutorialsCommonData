package com.hamitmizrak.javase_tutorials.paralel;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Log4j2
// @SneakyThrows  => Throws
public class _08_ThreadPoolExecuterServices implements Runnable {

    private long id;
    private String name;
    private String surname;

    //parametreli constructor
    public _08_ThreadPoolExecuterServices(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    // FULL NAME
    public void fullName() {
        System.out.println("Threading: " + this.name + this.surname);
    }

    // RUN
    @Override
    public void run() {
        System.out.println(" START");
        fullName();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" END");
    }


    // Manuel Thread process
    @SneakyThrows
    public static void manuelThread() {
        // Manuel Thread process
        Thread thread1 = new Thread(new _08_ThreadPoolExecuterServices(1, "Adı1", "Soyadı1"));
        Thread thread2 = new Thread(new _08_ThreadPoolExecuterServices(2, "Adı2", "Soyadı2"));
        Thread thread3 = new Thread(new _08_ThreadPoolExecuterServices(3, "Adı3", "Soyadı3"));
        Thread thread4 = new Thread(new _08_ThreadPoolExecuterServices(4, "Adı4", "Soyadı4"));
        Thread thread5 = new Thread(new _08_ThreadPoolExecuterServices(5, "Adı5", "Soyadı5"));

        // Thread
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join(); //1 ve 2 Thread bitmeden diğer Threadler başlamasın

        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join(); //3 ve 4 Thread bitmeden diğer Threadler başlamasın

        thread5.start();
        thread5.join();
    }

    // Dynamcis Thread Method
    @SneakyThrows
    public static void dynamicsThread() {
        // Dynamics Thread process
        // Thread Pool: Threadlerimizin bir arada olduğu yerdir.
        // Thread Pool: 2 tane Threadin aynı anda çalışmanı istiyoruz.
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            executorService.submit(new _08_ThreadPoolExecuterServices(i, "Adı" + i, "Soyadı" + i));
        }

        // Yukarıda Dinamik olarak yazdığımız Thread bitmeden yeni thread izin vermiyorum.
        // Eğer shutdown() yazmazsam ==> 5 Thread aynı anda çalışmaya başlar.
        // Eğer shutdown() yazarsam ==> Thread en kötü durumda  1 dakika sonra kapanacaktır.
        executorService.shutdown();

        System.out.println("Thread Continues Data");

        // Thread bitmesini zorlamak için yazdım
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Thread Bitti");
    }


    // All Thread Process
    public static void allThreadProcess(){
        while(true){
            Scanner klavye = new Scanner(System.in);
            System.out.println("\nLütfen seçim yapınız\n1-)Manuel Thread\n2-)Dinamik Thread\n3-)Çıkış");
            int key = klavye.nextInt();
            switch (key) {
                case 1:
                    // START TIME
                    long startTime1= System.currentTimeMillis();
                    manuelThread();
                    // END TIME
                    long endTime1=System.currentTimeMillis();
                    System.out.println("Toplam Geçen Süre: "+ Math.round(endTime1-startTime1)/1000);
                    break;

                case 2:
                    // START TIME
                    long startTime2= System.currentTimeMillis();
                    dynamicsThread();
                    // END TIME
                    long endTime2=System.currentTimeMillis();
                    System.out.println("Toplam Geçen Süre: "+ Math.round(endTime2-startTime2)/1000);
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor");
                    System.exit(0);
                    break;
            }
        }
    }

    // PSVM
    public static void main(String[] args) {
        allThreadProcess();
    } // end  PSVM
} // end _08_ThreadPoolExecuterServices
