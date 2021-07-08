package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = args[0];
        String fileName2 = args[1];
        //String fileName1 = "c:/tmp/9.txt";
        //String fileName2 = "c:/tmp/10.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        ) {
            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                String readedLine = reader.readLine();
                //System.out.println(readedLine);
                String[] words = readedLine.split(" ");
                for (String word: words) {
                    if (word.length() > 6) {
                        sb.append((sb.length() > 0 ? ",": "") + word);
                    }
                }
                //System.out.println(sb.toString());
            }
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
