package com.hamitmizrak.javase_tutorials.paralel;

// Eğer extends hakkını başka class kullanmışsa biz o zaman implements kullacağız
public class _03_ImplementsRunnable extends ThreadBase implements  Runnable{

    //constructor
    public _03_ImplementsRunnable(String threadName) {
        super(threadName);
    }

    //RUN
    @Override
    public void run() {
        for (int i = 1; i <=9 ; i++) {
            try {
                Thread.sleep(1000);
                if(i==1){
                    System.out.println("### Başlangıç ###");
                    System.out.println(getThreadName()+" ==> "+i+" ");
                }else if(i==9){
                    System.out.println("\n&&& Bitiş &&&");
                    System.out.println(getThreadName()+" ==> "+i+" ");
                }else{
                    System.out.println(getThreadName()+" ==> "+i+" ");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //PSVM
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(new _03_ImplementsRunnable("1.Thread"));
        Thread thread2=new Thread(new _03_ImplementsRunnable("2.Thread"));
        Thread thread3=new Thread(new _03_ImplementsRunnable("3.Thread"));

        //1.Thread bitsin
        thread1.start();
        thread1.join();

        //2.Thread devam etsin
        thread2.start();
        thread2.join();

        //3.Thread devam etsin
        thread3.start();
    }
}
