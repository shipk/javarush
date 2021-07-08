package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name; // not mandatory
    int age = 3;
    int weight = 5;
    String address; // not mandatory
    String color;

    public void initialize(String name) {
        this.name = name;
        this.age = 3;
        this.weight = 5;
        this.color = "unknown";
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "unknown";
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.weight = 5;
        this.age = age;
        this.address = null;
        this.color = "unknown";
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.age = 3;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 3;
    }
}
