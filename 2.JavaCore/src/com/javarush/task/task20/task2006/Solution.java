package com.javarush.task.task20.task2006;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
*/

public class Solution {
    public static class Human implements Serializable{
        public String name;
        public List<String> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, String... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Human human = new Human("ivanov", "car", "boat");

        FileOutputStream fos = new FileOutputStream("c:/tmp/2006.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(human);
        os.close();

    }
}
