package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
//        words.add("Б");
//        words.add("В");
//        words.add("А");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //String fileName = "c:/tmp/5.txt";

        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String s = reader.readLine();
            //System.out.println(s);

            String[] fileWords = s.split("\\s");

            int cnt = 0 ;
            for (int i = 0; i < fileWords.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (fileWords[i].equals(words.get(j))) {
                        cnt++;
                    }
                }
            }
            if (cnt == 2) {
                System.out.println(s);
            }

/*
            for (int i = 0; i < fileWords.length; i++) {
                System.out.print(fileWords[i]+"|");
            }
            System.out.println("");
*/
        }
        reader.close();
    }
}
