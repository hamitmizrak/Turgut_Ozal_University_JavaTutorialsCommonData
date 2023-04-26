package com.hamitmizrak.javase_tutorials.paralel;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

// LOMBOK
@Data
@NoArgsConstructor
@Log4j2
public class _06_Syncronized extends Thread{

    // Global Variable
    private String threadName;
    private static int counter=0;

    // parametreli constructor
    public _06_Syncronized(String threadName) {
        this.threadName = threadName;
    }

    // Counter Method => synchronized
    // synchronized: ilk giren Thread işini bitirmeden diğer Thread izin vermiyor.
    public synchronized void counterPlus(){
        //counter=counter+1;
        //counter+=1;
        counter++;
        System.out.println(counter);
        log.info(counter);
    }

    // Thread Run
    @Override
    public void run() {
        for (int i = 1; i <=9; i++) {
            System.out.println(threadName+" START");
            try {
                Thread.sleep(1000);
                // synchronized
                counterPlus();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException: "+e);
                throw new RuntimeException(e);
            }
        } // end for
        System.out.println(threadName+" END");
    } //end run

    // PSVM
    // Concurrency: Eş zamanlı çalışma demektir.
    // Senkron: Aynı sadece 1 iş yapabilme yeteneğidir.
    // Asenkron: Aynı sadece 1'den fazla iş yapabilme yeteneğidir.
    // MultiThreading: Aynı anda birden fazla iş yapabilme yeteneği
    public static void main(String[] args) throws InterruptedException {
        _06_Syncronized thread1=new _06_Syncronized("Threading-1");
        _06_Syncronized thread2=new _06_Syncronized("Threading-2");

        // START TIME
        long startTime= System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        //9(Döngü adet sayısı) * 2(thread) = 18(counter)
        System.out.println("Main Threading Counter "+counter);
        log.info("Main Threading Counter "+counter);

        // END TIME
        long endTime=System.currentTimeMillis();
        System.out.println("Toplam Geçen Süre: "+ Math.round(endTime-startTime)/1000);
    }
}
