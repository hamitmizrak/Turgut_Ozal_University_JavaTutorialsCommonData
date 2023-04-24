package com.hamitmizrak.javase_tutorials;

public class _03_Javase {
    //String

    public static void main(String[] args) {
        String value="Java Öğreniyorum Java ";
        System.out.println(value);
        System.out.println(value.length());
        System.out.println(value.trim().length());
        System.out.println(value.startsWith("J"));
        System.out.println(value.endsWith(" "));
        System.out.println(value.toUpperCase());
        System.out.println(value.toLowerCase());

        System.out.println(value.charAt(0));
        System.out.println(value.indexOf("Java"));
        System.out.println(value.lastIndexOf("Java"));

        System.out.println(value.substring(2));
        System.out.println(value.substring(0,3));//0<=X<=3-1
    }

    public  static void stringHomework(){
        // Ödev: Kullanıcıdan aldığınız isim ve soyismin; (isimi: scanner ve soyismi: jOptionalPane)
        //  bu kelimenin harf sayısı ? [ ipucu: length() ]
        //  bu kelimenin bütün karakteri büyük yapalım ? [ ipucu: toUpperCase()]
        //  bu kelimenin bütün karakteri küçük yapalım ? [ ipucu: toLowerCase()]
        //  bu kelimenin başında ve sonunda boşlukları alalım ? [ ipucu: trim()]
        //  bu kelimenin j ile başlıyoru mu ?   [ ipucu: startsWith("j")]
        //  bu kelimenin a ile biter mi ?   [ ipucu:  endsWith("a")]
        //  bu kelimenin ilk harfi ? [ ipucu: charAt(0)]
        //  bu kelimenin içinde baştan Altan geçiyor mu ? [ ipucu: indexOf("java")]
        //  bu kelimenin içinde sondan Berkan geçiyor mu ? [ ipucu: lastIndexOf("java")]
        //  bu kelimenin 4.harften sonra gösterilsin ? [ ipucu: substring(4)]
        //  bu kelimenin sonuna INC ekleyelim  ? [ ipucu: concat(".INC")]
        //  bu kelimenin içerisinde java44 geçiyor mu ? [ ipucu: contains("java44")]
        //  bu kelimenin "deneme" ile aynı mı ?  [ipucu: ipucu: equals("deneme");]
    }
}
