package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        //String fileName1 = "c:/tmp/1.txt";
        //String fileName2 = "c:/tmp/2.txt";

        StringBuilder builder = new StringBuilder("");
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        while (reader1.ready()) {
            builder.append((char)reader1.read());
        }
        reader1.close();

        String s = builder.toString();
        String[] parts = s.split("[^a-zA-Z0-9 \t]");
        //String[] parts = s.split("[a-z]");

        BufferedWriter writer2 = new BufferedWriter(new FileWriter(fileName2));
        for (int i = 0; i < parts.length; i++) {
            //System.out.println(parts[i]);
            writer2.write(parts[i]);
        }
        writer2.close();

    }
}
