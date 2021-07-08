package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //String fileName = "c:/tmp/8.txt";

        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String s = reader.readLine();
            Pattern pattern = Pattern.compile("\\b([0-9]+)\\b");
            Matcher matcher = pattern.matcher(s);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String num = matcher.group();
                int n = Integer.parseInt(num);
                if (map.containsKey(n))
                    num = map.get(n);
                matcher.appendReplacement(sb,  num);
            };
            matcher.appendTail(sb);
            System.out.println(sb.toString());
        }
        reader.close();
    }
}
