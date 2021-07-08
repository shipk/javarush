package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename  = reader.readLine();

        //FileOutputStream outputStream = new FileOutputStream(filename);
        //BufferedOutputStream buffer = new BufferedOutputStream(outputStream);
        BufferedWriter buf = new BufferedWriter(new FileWriter(filename));

        while (true) {
            String s = reader.readLine();
            buf.write(s + "\n");
            if (s.equals("exit"))
                break;
        }
        reader.close();
        buf.close();
        //outputStream.close();

    }
}
