package com.hamitmizrak.javase_tutorials;

import java.util.StringTokenizer;

public class _04_Javase {
    //StringBuilder
    //StringTokenizer
    public static void stringBuilderTutorials(){
        String data1="javase", data2="javaee", data3="javame";
        System.out.println(data1+data2+data3);

        System.out.println(data1.concat(data2).concat(data3));

        StringBuilder builder=new StringBuilder();
        builder.append(data1).append(data2).append(data3);
        String changeData=builder.toString();
        System.out.println(changeData);
    }

    public static void stringTokenizerTutorials(){
        String data="javase+-~javaee &javame";
        StringTokenizer tokenizer=new StringTokenizer(data,"+-~ &");
        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) {
        //stringBuilderTutorials();
        stringTokenizerTutorials();
    }
}
