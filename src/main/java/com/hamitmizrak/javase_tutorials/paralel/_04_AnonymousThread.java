package com.hamitmizrak.javase_tutorials.paralel;

public class _04_AnonymousThread extends ThreadBase {

    //constructor

    public _04_AnonymousThread(String threadName) {
        super(threadName);
    }

    public _04_AnonymousThread() {

    }

    public  void anonymousMethod() {
        // Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 9; i++) {
                    try {
                        Thread.sleep(1000);
                        if (i == 1) {
                            System.out.println("### Başlangıç ###");
                            System.out.println(builder().threadName("Thread 1") + " ==> " + i + " ");
                        } else if (i == 9) {
                            System.out.println("\n&&& Bitiş &&&");
                            System.out.println(builder().threadName("Thread 1") + " ==> " + i + " ");
                        } else {
                            System.out.println(builder().threadName("Thread 1") + " ==> " + i + " ");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } // end run
        }; // end Runnable
        runnable.run();
    }

    public static void main(String[] args) {
        _04_AnonymousThread anonymousThread=new _04_AnonymousThread();
        anonymousThread.anonymousMethod();
    }
}
