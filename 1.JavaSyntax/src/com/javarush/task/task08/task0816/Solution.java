package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Смирнов", dateFormat.parse("MAY 1 2012"));
        map.put("Смирнов2", dateFormat.parse("JUNE 1 2012"));
        map.put("Смирнов3", dateFormat.parse("JUNE 2 2012"));
        map.put("Смирнов4", dateFormat.parse("JUNE 3 2012"));
        map.put("Смирнов5", dateFormat.parse("JUNE 4 2012"));
        map.put("Смирнов6", dateFormat.parse("JUNE 5 2012"));
        map.put("Смирнов7", dateFormat.parse("JUNE 6 2012"));
        map.put("Смирнов8", dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Смирнов9", dateFormat.parse("NOVEMBER 2 2012"));
        map.put("Смирнов10", dateFormat.parse("NOVEMBER 3 2012"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Date> pair = it.next();
            if (pair.getValue().getMonth() >= 5 && pair.getValue().getMonth() <= 7)
                it.remove();
        }
    }

    public static void main(String[] args) throws ParseException {
/*
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
        System.out.println(map);
*/
    }
}
