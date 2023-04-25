package com.hamitmizrak.javase_tutorials.paralel;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class _02_ExtendsThread extends Thread {

    // Global variable
    private String threadName;

    // Run
    @Override
    public void run() {
        for (int i = 1; i <=9 ; i++) {
            try {
                Thread.sleep(1000);
                if(i==1){
                    System.out.println("### Başlangıç ###");
                    System.out.println(this.threadName+" ==> "+i+" ");
                }else if(i==9){
                    System.out.println("\n&&& Bitiş &&&");
                    System.out.println(this.threadName+" ==> "+i+" ");
                }else{
                    System.out.println(this.threadName+" ==> "+i+" ");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // PSVM
    public static void main(String[] args) throws InterruptedException {
        _02_ExtendsThread thread1=new _02_ExtendsThread("1.Thread");
        _02_ExtendsThread thread2=new _02_ExtendsThread("2.Thread");
        _02_ExtendsThread thread3=new _02_ExtendsThread("3.Thread");

        //Thread Information
        /*
        System.out.println("Thread 1 is Alive==>"+thread1.isAlive());
        thread1.start();
        System.out.println("Thread 1 is Alive==>"+thread1.isAlive());
        System.out.println("Thread 1 is hashCode==>"+thread1.hashCode());
        System.out.println("Thread 2 is hashCode==>"+thread2.hashCode());
        System.out.println("Thread 1 is getName==>"+thread1.getName());
        thread1.setName("MyspecialThread ".concat(UUID.randomUUID().toString()) );
        System.out.println("Thread 1 is getName==>"+thread1.getName());
        */

        //Join: öncelikle belirlediğim thread bitsin sonrasında diğer thread başlasın
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        thread3.start();

    }
}
