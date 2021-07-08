package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        //map.put("bbb", "222");
        map.put(null, null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder where = new StringBuilder("");
        for (String key : params.keySet()) {
            if (key == null) continue;
            if (params.get(key) == null) continue;
            if (where.length() > 0)
                where.append(" and ");
            where.append(key);
            where.append(" = '");
            where.append(params.get(key));
            where.append("'");
        }
        return where.toString();
    }
}
