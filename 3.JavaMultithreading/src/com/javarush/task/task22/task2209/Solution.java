package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");
        try {
            String fileName = reader.readLine();
            reader.close();
            reader = new BufferedReader((new FileReader(fileName)));
            while (reader.ready()) {
                sb.append(reader.readLine());
                sb.append(" ");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = sb.toString().split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString().trim());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new LinkedList<String>();
        for (String w : words) {
            list.add(w);
        }
        String s = getChain(null, list, "");
        if (s == null) s = "";
        return new StringBuilder(s);
    }

    public static String getChain(String s, List<String> words, String tab) {
        if (words.size() == 0) return "";
        for (int i = 0; i < words.size(); i++) {
            String w = words.get(i);

            if (s == null || s.substring(s.length()-1).toLowerCase().equals(w.substring(0,1).toLowerCase())) {
                List<String> localWords = new LinkedList<>();
                localWords.addAll(words);
                localWords.remove(i);
                String t = getChain(w, localWords, tab + "  ");
                if (t != null) {
                    return w + " " + t;
                }
            }
        }
        return null;
    }
}
