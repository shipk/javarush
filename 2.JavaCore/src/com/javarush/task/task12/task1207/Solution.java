package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
        Integer i;
        i = 1;
        print(i);
    }

    //Напишите тут ваши методы
    public static void print(int i) {
        System.out.println(i);
        System.out.println("aa");
    }
    public static void print(Integer i) {
        System.out.println(i);
        System.out.println("bb");
    }
}
