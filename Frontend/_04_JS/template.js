// comment 
/* multiple comment*/

// alert("deneme")
// window.alert("deneme44")
// window.document.write("ana ekran");
// console.log("console")
// console.warn("console")
// console.error("console")
// console.info("console")

var deneme1 = 44;
var deneme1 = 55;

// var let const farklar ?
//Ecmascript nedir ?
//React: +ES6

// let result=prompt("isminizi giriniz");
// console.log(result)

// "" '' ``

let $_valueName44 = 44;
console.log($_valueName44)
console.log(typeof $_valueName44)

//  whoisting: dikkat var için kullan
deneme = 10 + 20;
var deneme;
console.log(deneme)

//cast
// let data1=Number(prompt("sayı giriniz")) ;
// console.log(typeof data1)

// NaN undefined infinity 
// NaN 
console.log(4 / "asd")

// infinity 
console.log(4 / 0)


let data;
console.log(data)

//escape character 
//  \'  \"

//String 
let vocabulary = "Javascript öğreniyorum Javascript ";
console.log(vocabulary)
console.log(vocabulary.toLowerCase())
console.log(vocabulary.toUpperCase())
console.log(vocabulary.length)
console.log(vocabulary.trim().length)
console.log(vocabulary.charAt(0))
console.log(vocabulary.indexOf("Javascript"))
console.log(vocabulary.lastIndexOf("Javascript"))
console.log(vocabulary.startsWith("J"))
console.log(vocabulary.endsWith(" "))
console.log(vocabulary.substring(1))
console.log(vocabulary.substring(1, 4)) //1<=X<=4-1

//Math
console.log(Math.min(1, 100, 200))
console.log(Math.max(1, 100, 200))
console.log(Math.sqrt(100))
console.log(Math.abs(-100))
console.log(Math.pow(2, 5))
console.log(Math.sin(45))
console.log(Math.floor(5.9))
console.log(Math.ceil(5.1))
console.log(Math.round(7.4))
console.log(Math.round(7.5))

//function
function returnsuzParametresiz() {
    console.log("returnsuz parametresiz")
}
returnsuzParametresiz()

function returnsuzParametreli(data) {
    console.log("returnsuz parametreli " + data)
}
returnsuzParametreli("kelime")

function returnluParametresiz() {
    return "returnluParametresiz"
}
let data5 = returnluParametresiz()
console.log(data5)

function returnluParametreli(number) {
    return "returnluParametreli " + number;
}
let data6 = returnluParametreli()
console.log(data6)
///////////////////////////////////////////////

// normal function 
function normal() {
    console.log("normal")
}
normal()

// anonymous function
let anonymous = function () {
    console.log("anonymous")
}
anonymous()

// arrow function
let arrow = () => {
    console.log("arrow")
}
arrow()

/////////////////////////////////////$
//contional 
let contional = () => {
    let data = 5;
    if (data > 0) {
        console.log("pozitif sayı")
    } else
        console.log("negatif sayı")
    //ternary ÖDEV
}
contional()

// = atama
// == eşitmi ancak türüne bakmadan
// === =eşitmi ancak türüne bakarak
let contional2 = () => {
    let data = 5;
    if (data == 1) {
        console.log("1")
    } else if (data === 2) {
        console.log("2")
    } else if (data === 3) {
        console.log("3")
    } else if (data === 4) {
        console.log("4")
    } else if (data === 5) {
        console.log("5")
    } else
        console.log("negatif sayı")
    //ternary ÖDEV
}
contional2()


//loop 
let loop = () => {
    for (let i = 0; i < 10; i++) {
        document.write(i + " ")
    }
}
loop()

document.writeln("<br/>")

let loop2 = () => {
    let i = 0;
    while (i < 10) {
        document.write(i + " ")
        i++
    }
}
loop2()

document.writeln("<br/>")
let loop3 = () => {
    let i = 0;
    do {
        document.write(i + " ")
        i++
    } while (i < 10);
}
loop3()

//ÖDEV
//break 
//return 
//continue

//ÖDEV (if-else for break continue)
//Fonksiyonlarla
//Örnek: 1 ile kullanıcının vereceği (prompt) bitiş sayısına göre
//kullancı: 5 verdi diyelim 1<=X<=5
//1.adım: kaç tane sayı var ?
//2.adım: sayı toplamları var ?
//3.adım: kaç tane tek  sayı var ?
//4.adım: tek sayılar toplamı ?
//5.adım: tek sayılar gösterelim ?
//6.adım: kaç tane çift  sayı var ?
//7.adım: çift sayılar toplamı ?
//8.adım: çift sayılar gösterelim ?
//Eğer verilen sayılarda 7 sayısı varsa bunu eklemesin (continue)
//Eğer bitiş sayısı 100 fazla ise 100'e kadar olanlar toplansın  (break)
//Eğer kullanıcı başlangıç sayıdan küçük girerse uyaralım başlangıçtan büyük girmesini isteyelim
//Eğer kullanıcı secret-key girerse yani 44 sayısını girerse program çalışmayı direk durdursun

//ÖDEV 
//NOT: örneklerimizi function,anonymous ve arrow function ile yapalım.
//NOT: değişken olarak var,let,const kullanalım.
//NOT: örneklerimizi function,anonymous ve arrow function ile yapalım.
//NOT: değişken olarak var,let,const kullanalım.
//Örnek-1
//y=3x+4k ==>1.dereceden2bilinmeyenlidenklem algoritması
//Kullanıcı tarafından alınan x ve kdeğerlerini hesaplayan algoritma yazınız ?
//örnek-2
//Kullanıcı tarafından alınan dereceyi  Fahrenhayta çeviren algoritma yapalım.
//Formül: (derece*9/5)+32
//örnek-3 operatör işlemleri: aşağıdaki örneği javascript ile yapalım
//4+3*2(3:3-1*6+9:1+(3:3))

//NOT: örneklerimizi function,anonymous ve arrow function ile yapalım.
//NOT: değişken olarak var,let,const kullanalım.
//NOT: örneklerimizi function,anonymous ve arrow function ile yapalım.
//NOT: değişken olarak var,let,const kullanalım.
//Örnek-1
//y=3x+4k ==>1.dereceden2bilinmeyenlidenklem algoritması
//Kullanıcı tarafından alınan x ve kdeğerlerini hesaplayan algoritma yazınız ?
//örnek-2
//Kullanıcı tarafından alınan dereceyi  Fahrenhayta çeviren algoritma yapalım.
//Formül: (derece*9/5)+32
//örnek-3 operatör işlemleri: aşağıdaki örneği javascript ile yapalım
//4+3*2(3:3-1*6+9:1+(3:3))

//ÖDEV 
//Örnek-4: Aşağıdaki örnekleri math ile çözelim ?
// -5.9 sayıyının aşağıdaki işlemleri yaptıralım ?
// 1-mutlak değeri alsın 5.9
// 2-yuvarlama yapsın  6.0
// 3-karesini alsın 36.00
// 4-karekök alsın 6.0
// 5-yuvarlama yapsın 6.0
// 6-)çıkan sonucu 5 bölsün 6/5=1
// 7-) iki sayı arasından karşılaştırma yapsın en küçüğünü alsın ve 1 ve 5
// 8-) küçük sayı eğer tekse 3 eklesin çiftse 5 eklesin 
// Örnek-5 : kullanıcı tarafından girilen bir sayıyı negatif mi pozitif mi olduğu ekran yazdıran algoritma ?
//NOT: cast kullalım ?
// Örnek-6 : kullanıcı tarafından password ve repassword alalım sonrasında bu iki değeri karşılaştırma yapalım
//eğer aynı girilirse aynı veri yoksa birbirine uymadı yazan algoritma yapalım

//Exceptioın handling
document.writeln("<br/>")
let value = () => {
    try {
        document.write("1.alan" )
        alertx("data")
        
    } catch (error) {
        document.write("Err: " + error)
    }finally{
        document.write("<br/>db.close" )
    }
}
value()

//Dizi 
let arr=[44,"str",true];
console.log(typeof arr)
console.log( arr)

document.writeln("<br/>")
let dizi = () => {
    let temp;
    let sum=0;
    let dizi=[];
    for (let index = 0; index < 5; index++) {
       temp=Math.round(Math.random()*9+1);
       dizi[index]=temp;
       sum+=dizi[index];
    }
    //console.log(dizi)
    dizi.forEach(function(value){
        console.log(value)
    });
    document.write("<br/>")
    dizi.forEach((value)=>{
        console.log(value)
    });
    console.log(sum)
}
dizi()

//filter
document.writeln("<br/>")
let filter = () => {
   let dizi=[1,2,3,4,5,6,7,8];
   let result=dizi.filter((temp)=>{
    return temp%2===1
   });
   result.forEach((temp)=>{
    document.writeln(temp)
   });
}
filter()

//OBJECT
document.writeln("<br/>")
let object = () => {
    let obj={
        "name":"Hamit",
        "surname":"Mızrak",
        "language":12,
        "isLogin":true,
        "dizi":[1,2,3,4],
        "innerObj":{
            "name":"computer",
        }
    };
    console.log(obj)
    console.log(obj.name.toUpperCase())
    console.log(obj.dizi[3])
}
object()

//Date
document.writeln("<br/>")
let date = () => {
    let value=new Date().getFullYear();
    console.log(value)
}
date()



