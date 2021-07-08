package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        try (
            FileOutputStream fos1 = new FileOutputStream(fileName1);
            FileInputStream fos2 = new FileInputStream(fileName2);
            FileInputStream fos3 = new FileInputStream(fileName3);
            )
        {
            int b;
            while ((b = fos2.read()) != -1) {
                fos1.write(b);
            }
            while ((b = fos3.read()) != -1) {
                fos1.write(b);
            }
        }
    }
}
