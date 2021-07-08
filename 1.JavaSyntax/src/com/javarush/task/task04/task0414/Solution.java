package com.javarush.task.task04.task0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Количество дней в году
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int y = Integer.parseInt(s);
        System.out.println("количество дней в году: "+get(y));
    }
    public static int get(int y) {
        if (400*(y/400) == y)
            return 366;
        else if (100*(y/100) == y)
            return 365;
        else if (4*(y/4) == y)
            return 366;
        else
            return 365;
    }
}