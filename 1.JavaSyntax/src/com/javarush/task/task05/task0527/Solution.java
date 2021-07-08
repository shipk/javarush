package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Cat tomCat = new Cat("Tom", 5, 5);
        Dog wagDog = new Dog("wag", 10, 10);


        //напишите тут ваш код
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Dog {
        String name;
        int height;
        int age;

        public Dog(String name, int height, int age) {
            this.name = name;
            this.height = height;
            this.age = age;
        }
    }

    public static class Cat {
        String name;
        int weight;
        int age;

        public Cat(String name, int weight, int age) {
            this.name = name;
            this.weight = weight;
            this.age = age;
        }
    }

    //напишите тут ваш код
}
