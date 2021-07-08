package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.ArrayList;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] cnts = new int[256];
        try (FileInputStream fis = new FileInputStream(args[0]);) {
            while (fis.available() > 0) {
                int b = fis.read();
                cnts[b]++;
            }
        }
        for (int i=0; i<256; i++) {
            if (cnts[i] != 0)
                System.out.printf("%c %d\n", i, cnts[i]);
        }
    }
}
