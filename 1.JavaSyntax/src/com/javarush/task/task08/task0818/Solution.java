package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < 10; i++) {
            map.put("a"+i, 100*i);
        }
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> e = iter.next();
            if (e.getValue() < 500)
                iter.remove();
        }
    }

    public static void main(String[] args) {
/*
        Map<String, Integer> map = createMap();
        System.out.println(map);
        removeItemFromMap(map);
        System.out.println(map);
*/
    }
}