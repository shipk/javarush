package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName1 = args[0];
        String fileName2 = args[1];
/*
        String fileName1 = "c:/tmp/2211_in.txt";
        String fileName2 = "c:/tmp/2211_out.txt";
*/

        byte[] buffer = new byte[1000];
        InputStream inputStream = new FileInputStream(fileName1);
        OutputStream outputStream = new FileOutputStream(fileName2);
        while (true) {
            int n = inputStream.read(buffer);
            if (n == -1) break;
            String s = new String(buffer, "Windows-1251");
            byte[] buffer1 = s.getBytes("UTF8");
            outputStream.write(buffer1, 0, n*2);
        }
        inputStream.close();
        outputStream.close();
    }
}
