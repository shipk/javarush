package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("a0", new Cat("a0"));
        map.put("a1", new Cat("a1"));
        map.put("a2", new Cat("a2"));
        map.put("a3", new Cat("a3"));
        map.put("a4", new Cat("a4"));
        map.put("a5", new Cat("a5"));
        map.put("a6", new Cat("a6"));
        map.put("a7", new Cat("a7"));
        map.put("a8", new Cat("a8"));
        map.put("a9", new Cat("a9"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        set.addAll(map.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
