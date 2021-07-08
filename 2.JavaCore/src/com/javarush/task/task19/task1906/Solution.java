package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader f1 = new FileReader(fileName1);
        FileWriter f2 = new FileWriter(fileName2);

        long cnt = 1;
        while (f1.ready()) {
            int c = f1.read();
            if ((cnt % 2) == 0) {
                f2.write(c);
            }
            cnt++;
        }

        f1.close();
        f2.close();
    }
}
