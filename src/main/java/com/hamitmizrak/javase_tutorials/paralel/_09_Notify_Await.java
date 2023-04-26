package com.hamitmizrak.javase_tutorials.paralel;

import lombok.SneakyThrows;
import java.util.Scanner;

// await: ikinci bir emre kadar bekle
// notify: artık emir geldi kalkabilirsin
// notifyAll(): Bütün Threadleri kaldırır.
public class _09_Notify_Await {
    // Global Variable
    private Scanner klavye = new Scanner(System.in);
    private Object lockData = new Object(); // Object

    // await Method
    @SneakyThrows // Lombok
    public void awaitMethod() throws InterruptedException {
        //synchronized (this){}
        synchronized (lockData) {
            System.out.println("1.Thread çalıştı ancak bundan sonraki 2.Thread  çalışması için 1.Thread çalışması gerekiyor.");
            lockData.wait();
        }
        System.out.println("Thread Uykudan Kalktı");
    }

    // notify Method
    @SneakyThrows // Lombok
    public void notifyMethod() {
        Thread.sleep(2000);
        synchronized (lockData) {
            System.out.println("2.Thread Devam etmesi için 1.Thread devam etmelidir bunun için \nherhangi bir tuşa basınız");
            klavye.nextLine();
            lockData.notify();
            System.out.println("1.Thread uyandı ve 2.Thread 5 saniye uyanacak ve sonra devam edecek");
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " saniye");
            Thread.sleep(1000);
        }
    }

    // All Thread Process
    @SneakyThrows
    public static void allThreadProcess() {
        _09_Notify_Await notify_await = new _09_Notify_Await();

        // Anonymous Thread-1 ( Yatıyor)
        Runnable thread1=() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread-X1");
            }
            try {
                notify_await.awaitMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        //Thread oluştur ==> interface Anonymous Lambda Expression
        Thread lambdaThread=new Thread(thread1);

        // Anonymous Thread-2 (notify: uyandırıyor)
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                notify_await.notifyMethod();
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread-X2");
                }
            }
        }); // end thread2

        lambdaThread.start();
        thread2.start();
        lambdaThread.join();
        thread2.join();

    } // end allThreadProcess

    // PSVM
    public static void main(String[] args) {
        allThreadProcess();
    } // end  PSVM
} // end _09_Notify_Await