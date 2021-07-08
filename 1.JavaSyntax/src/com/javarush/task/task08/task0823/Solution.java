package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char p = ' ';
        for (char c:
             string.toCharArray()) {
            if (p == ' ' && c != ' ')
                System.out.print(Character.toUpperCase(c));
            else
                System.out.print(c);
            p = c;
        }

        //напишите тут ваш код
    }
}
