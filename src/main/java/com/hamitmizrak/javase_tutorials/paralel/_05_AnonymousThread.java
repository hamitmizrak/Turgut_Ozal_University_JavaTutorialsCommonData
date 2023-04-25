package com.hamitmizrak.javase_tutorials.paralel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class _05_AnonymousThread  {

    //Global Varaible
    private String theadName;


    // Anonymous thread
    public void anonymousMethod() {
        _05_AnonymousThread anonymousThread=new _05_AnonymousThread("Thread-1");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(anonymousThread+" Start Threading ...");
                for (int i = 1; i <=9 ; i++) {
                    System.out.println(anonymousThread+" "+i+" Continue Threading ...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } //end for
                System.out.println(anonymousThread+" Finish Threading ...");
            } // end run
        }); //end thread
        thread.start();
    }


    // Anonymous thread
    public void anonymousMethodLambdaExpression() {
        _05_AnonymousThread anonymousThread=new _05_AnonymousThread("Thread-2");
        Thread thread=new Thread(()-> {
                System.out.println(anonymousThread+" Lambda Expression Start Threading ...");
                for (int i = 1; i <=9 ; i++) {
                    System.out.println(anonymousThread+" "+i+" Continue Threading ...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } //end for
                System.out.println(anonymousThread+" Finish Threading ...");
        }); //end thread
        thread.start();
    }


    // PSVM 1170
    public static void main(String[] args) {
        _05_AnonymousThread anonymousThread = new _05_AnonymousThread();
        //anonymousThread.anonymousMethod();
        anonymousThread.anonymousMethodLambdaExpression();
    }
}
