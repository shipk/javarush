package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inFileName = args[0];
        String outFileName = args[1];
        //String inFileName = "c:/tmp/6.txt";
        //String outFileName = "c:/tmp/7.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
        while (reader.ready()) {
            String readedLine = reader.readLine();
            String[] words = readedLine.split(" ");
            for (String word : words) {
                //System.out.println(word);
                if (word.matches(".*[0-9].*")) {
                    //System.out.println(word);
                    writer.write(word + " ");
                }
            }
        }
        writer.close();
        reader.close();
    }
}
