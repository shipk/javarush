package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(fileName2));
        while (reader1.ready()) {
            char c = (char) reader1.read();
            if (c == '.')
                c = '!';
            writer2.write(c);
        }
        writer2.close();
        reader1.close();
    }
}
