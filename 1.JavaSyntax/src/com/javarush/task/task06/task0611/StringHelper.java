package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String text) {
        //напишите тут ваш код
        return multiply(text, 5);
    }

    public static String multiply(String text, int count) {
        String result = "";
        for (int i = 0; i < count ; i++) {
            result = result+text;
        }
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {
        System.out.println(multiply("a"));
    }
}
