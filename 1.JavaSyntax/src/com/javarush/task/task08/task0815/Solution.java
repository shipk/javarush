package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            map.put("a"+i, "b"+i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int i = 0;
        for (Map.Entry<String, String> m :
                map.entrySet()) {
            if (m.getValue().equals(name))
                i++;
        }
        return i;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        int i = 0;
        for (Map.Entry<String, String> m :
                map.entrySet()) {
            if (m.getKey().equals(lastName))
                i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        //System.out.println(getCountTheSameLastName(map, "b1"));
        //System.out.println(getCountTheSameFirstName(map, "b1"));
    }
}
