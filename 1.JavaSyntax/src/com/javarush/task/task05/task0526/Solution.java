package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Andy", 30, "aa1");
        Man man2 = new Man("Cozel", 31, "aa2");

        System.out.println(man1);
        System.out.println(man2);

        Woman woman1 = new Woman("caca", 16, "bb1");
        Woman woman2 = new Woman("ceca", 18, "bb2");

        System.out.println(woman1);
        System.out.println(woman2);

    }

    public static class Man {
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return  name + " " + age + " " + address;
        }
    }

    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return  name + " " + age + " " + address;
        }
    }

    //напишите тут ваш код
}
