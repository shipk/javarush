package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        //String fileName1="c:/tmp/1.txt";
        //String fileName2="c:/tmp/2.txt";

        reader = new BufferedReader(new FileReader(fileName1));
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append((char)reader.read());
        }
        reader.close();
        String s = builder.toString();

        String[] parts = s.split("[ \t]");
        String result = "";
        for (int i=0; i<parts.length; i++) {
            if (parts[i].matches("^[0-9]+$"))
                result += ((result.length() == 0) ? "" : " ") + parts[i];
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        writer.write(result);
        writer.close();
    }
}
