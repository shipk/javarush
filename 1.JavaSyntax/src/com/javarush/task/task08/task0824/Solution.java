package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human ch1 = new Human("Anna", false, 4, new ArrayList<Human>());
        Human ch2 = new Human("Max", true, 3, new ArrayList<Human>());
        Human ch3 = new Human("Elen", false, 5, new ArrayList<Human>());

        Human mother = new Human("Mila", false, 30, new ArrayList<Human>(Arrays.asList(ch1, ch2, ch3)));
        Human father = new Human("Ted", true, 30, new ArrayList<Human>(Arrays.asList(ch1, ch2, ch3)));

        Human mgf = new Human("Dob", true, 80, new ArrayList<Human>(Arrays.asList(mother)));
        Human mgm = new Human("Nina", false, 80, new ArrayList<Human>(Arrays.asList(mother)));

        Human fgf = new Human("Bob", true, 80, new ArrayList<Human>(Arrays.asList(father)));
        Human fgm = new Human("Bina", false, 80, new ArrayList<Human>(Arrays.asList(father)));

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);

        System.out.println(mother);
        System.out.println(father);

        System.out.println(mgf);
        System.out.println(mgm);

        System.out.println(fgf);
        System.out.println(fgm);
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
