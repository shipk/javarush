package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human gf1 = new Human("gf1", true, 80);
        Human gm1 = new Human("gm1", false, 80);

        Human gf2 = new Human("gf2", true, 70);
        Human gm2 = new Human("gm2", false, 70);

        Human f = new Human("f", true, 35, gf1, gm1);
        Human m = new Human("m", false, 35, gf2, gm2);

        Human c1 = new Human("c1", true, 1, f, m);
        Human c2 = new Human("c2", true, 2, f, m);
        Human c3 = new Human("c3", true, 3, f, m);

        System.out.println(gf1);
        System.out.println(gm1);

        System.out.println(gf2);
        System.out.println(gm2);

        System.out.println(f);
        System.out.println(m);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    public static class Human {
        // напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}