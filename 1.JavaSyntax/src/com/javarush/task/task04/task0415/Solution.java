package com.javarush.task.task04.task0415;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Правило треугольника
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String s3 = bufferedReader.readLine();

        Double a = Double.parseDouble(s1);
        Double b = Double.parseDouble(s2);
        Double c = Double.parseDouble(s3);

        if (a<b+c && b < a+c && c<a+b) {
            System.out.println("Треугольник существует.");
        } else {
            System.out.println("Треугольник не существует.");

        }
    }
}