package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Cat catMother = new Cat(motherName);

        //String daughterName = reader.readLine();
        //Cat catDaughter = new Cat(daughterName, catMother);

        String name = reader.readLine();
        //Cat gf = new Cat("дедушка Вася");
        Cat gf = new Cat(name);

        name = reader.readLine();
        //Cat gm = new Cat("бабушка Мурка");
        Cat gm = new Cat(name);

        name = reader.readLine();
        //Cat f = new Cat("папа Котофей", null, gf);
        Cat f = new Cat(name, null, gf);

        name = reader.readLine();
        //Cat m = new Cat("мама Василиса", gm, null);
        Cat m = new Cat(name, gm, null);

        name = reader.readLine();
        //Cat s = new Cat("сын Мурчик", m, f);
        Cat s = new Cat(name, m, f);

        name = reader.readLine();
        //Cat d = new Cat("дочь Пушинка", m, f);
        Cat d = new Cat(name, m, f);

        System.out.println(gf);
        System.out.println(gm);
        System.out.println(f);
        System.out.println(m);
        System.out.println(s);
        System.out.println(d);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            String s = "The cat's name is " + name;

            if (mother != null)
                s = s + ", mother is " + mother.name;
            else
                s = s + ", no mother";

            if (father != null)
                s = s + ", father is " + father.name;
            else
                s = s + ", no father";

            return s;
        }
    }

}
