package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Иван");
        map.put("Смирнов", "Иван");
        map.put("Ванин", "Максим");

        map.put("Иванов", "Иван");
        map.put("Смирнов", "Иван");
        map.put("Ванин", "Максим");

        map.put("Иванов", "Иван");
        map.put("Смирнов", "Иван");
        map.put("Ванин", "Максим");

        map.put("Иванов", "Иван");

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
