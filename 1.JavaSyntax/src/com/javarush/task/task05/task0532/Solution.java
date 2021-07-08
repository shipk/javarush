package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());
        if (maximum<=0) return;
        int m = 0;
        for (int i = 0; i <maximum ; i++) {
            int t = Integer.parseInt(reader.readLine());
            if (i == 0) m = t;
            if (t > m) m = t;
        }
        System.out.println(m);

        //напишите тут ваш код
    }
}
