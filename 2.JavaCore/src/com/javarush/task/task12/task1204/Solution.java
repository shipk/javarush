package com.javarush.task.task12.task1204;

/* 
То ли птица, то ли лампа
*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
        String s  = "";
        if (o instanceof Cat)
            s = "Кошка";
        else if (o instanceof Dog)
            s = "Собака";
        else if (o instanceof Bird)
            s = "Птица";
        else if (o instanceof Lamp)
            s = "Лампа";
        System.out.println(s);
    }

    public static class Cat {
        public String printType() {
            return "Кошка";
        }
    }

    public static class Dog {
        public String printType() {
            return "Собака";
        }
    }

    public static class Bird {
        public String printType() {
            return "Птица";
        }
    }

    public static class Lamp {
        public String printType() {
            return "Лампа";
        }
    }
}
