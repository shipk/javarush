package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fis = new FileInputStream(fileName);
        int max = 0;
        while (fis.available() > 0) {
            int b = fis.read();
            if (b > max) max = b;
        }
        fis.close();
        System.out.println(max);
    }
}
