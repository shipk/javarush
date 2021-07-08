package com.javarush.task.task07.task0715;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<String > list = new ArrayList<String>();
        Collections.addAll(list, "мама", "мыла", "раму");
        list.add(3, "именно");
        list.add(2, "именно");
        list.add(1, "именно");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
