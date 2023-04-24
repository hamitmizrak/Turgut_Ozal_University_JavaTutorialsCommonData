package com.hamitmizrak.javase_tutorials.oop.inheritancex;

public class InheritanceMainClass {
    public static void main(String[] args) {

        //Person
        Person person = new Person();
        person.setId(1L);
        person.setUsername("Person adı-1");
        person.setSurname("Person soyadı-1");
        System.out.println(person);

        //Student
        Student student = new Student();
        student.setId(1L);
        student.setUsername("öğrenci adı-1");
        student.setSurname("öğrenci soyadı-1");
        student.deneme("stu");
        student.setUnicodeCharacter("unicode 441");
        System.out.println(student);

        //Teacher
        Teacher teacher = new Teacher();
        teacher.setId(2L);
        teacher.setUsername("öğretmen adı-1");
        teacher.setSurname("öğretmen soyadı -1");
        student.deneme("öğret");
        System.out.println(teacher);
    }
}
