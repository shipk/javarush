package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("Амиго и Диего лучшие"));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        int start = string.indexOf(" ")+1;
        if (start == -1) throw new TooShortStringException();
        int end = start;

        end = string.indexOf(" ", end);
        if (end == -1) throw new TooShortStringException();

        end = string.indexOf(" ", end+1);
        if (end == -1) throw new TooShortStringException();

        end = string.indexOf(" ", end+1);
        if (end == -1) throw new TooShortStringException();

        end = string.indexOf(" ", end+1);
        if (end == -1) end = string.length();

        return string.substring(start, end);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
