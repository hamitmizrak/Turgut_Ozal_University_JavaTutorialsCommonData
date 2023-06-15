package com.hamitmizrak.finalhome.parallelprogramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ParallelService extends Thread{
    public static final String PERSON_URL = "c:\\io\\turgutozaluniversitesi\\person.txt";
    public static final String SECRET_URL = "c:\\io\\turgutozaluniversitesi\\secret.txt";

    //1.VERİ
    public String userDataInformation() {
        Scanner klavye = new Scanner(System.in);
        String username, password, email;
        System.out.println("Username giriniz");
        username = klavye.nextLine();
        System.out.println("Password giriniz");
        password = klavye.nextLine();
        System.out.println("email giriniz");
        email = klavye.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(username).append(password).append(email);
        return stringBuilder.toString();
    }

    public void fileIouserDataInformation() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PERSON_URL, false))) {
            String userData = userDataInformation();
            bufferedWriter.write(userData);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////////////
    //2.VERİ
    public String userDataSecretInformation() {
        Scanner klavye = new Scanner(System.in);
        String secretInformation;
        System.out.println("secretInformation giriniz");
        secretInformation = klavye.nextLine();
        return secretInformation;
    }

    public void fileIouserSecretInformation() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SECRET_URL, false))) {
            String userData = userDataSecretInformation();
            bufferedWriter.write(userData);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////////////////////////////////////////////
    // MultiThread
    public static void main(String[] args) throws InterruptedException {
        // 1.Thread
        ParallelService parallelService1=new ParallelService();
        parallelService1.fileIouserDataInformation();// fileIouserDataInformation

        // 2.Thread
        ParallelService parallelService2=new ParallelService();
        parallelService2.fileIouserSecretInformation();// fileIouserDataInformation

        parallelService1.start();
        parallelService1.join();

        parallelService2.start();
        parallelService2.join();
    }


}
