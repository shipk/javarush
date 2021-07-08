package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("ф1", "и1");
        map.put("ф2", "и2");
        map.put("ф3", "и3");
        map.put("ф4", "и1");
        map.put("ф5", "и1");
        map.put("ф6", "и1");
        map.put("ф7", "и1");
        map.put("ф8", "и1");
        map.put("ф9", "и1");
        map.put("ф10", "и11");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Map<String, Integer> counters = new HashMap<String, Integer>();
        for (String name :
                map.values()) {
            if (counters.keySet().contains(name)) {
                counters.put(name, counters.get(name)+1);
            } else {
                counters.put(name, 1);
            }
        }
        for (Map.Entry<String, Integer> e : counters.entrySet()) {
            if (e.getValue() > 1)
                removeItemFromMapByValue(map, e.getKey());
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
/*
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        System.out.println(map);
*/
    }
}
