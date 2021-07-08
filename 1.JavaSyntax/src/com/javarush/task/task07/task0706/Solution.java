package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int[] a = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        int nOdd = 0;
        int nEven = 0;
        for (int i = 0; i < 15; i=i+2) {
            nEven += a[i];
        }
        for (int i = 1; i < 15; i=i+2) {
            nOdd += a[i];
        }
        if (nOdd > nEven)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else if (nOdd < nEven)
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
