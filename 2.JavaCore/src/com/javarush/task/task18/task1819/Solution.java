package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (
                FileInputStream fos1 = new FileInputStream(fileName1);
            )
        {
            while (fos1.available() > 0) {
                baos.write(fos1.read());
            }
        }

        try (
                FileOutputStream fos1 = new FileOutputStream(fileName1);
                FileInputStream fos2 = new FileInputStream(fileName2);
            )
        {
            while (fos2.available() > 0) {
                fos1.write(fos2.read());
            }
            baos.writeTo(fos1);
        }
    }
}
