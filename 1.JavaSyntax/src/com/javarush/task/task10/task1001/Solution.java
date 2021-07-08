package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;

        int b = (byte) a + 46;
        //System.out.println("b=" +b);

        byte c = (byte) (a * b);
        //System.out.println("c=" +c);

        double f = (double) 1234.15;
        //System.out.println("f=" +f);

        long d = (int) (a + f / c + b);
        System.out.println(d);
    }
}
