package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            File file = new File(Statics.FILE_NAME);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            while (true) {
                String s = reader.readLine();
                if (s == null)
                    break;
                lines.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
