package com.javarush.task.task19.task1926;

import java.io.*;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //String fileName = "c:/tmp/11.txt";

        try (BufferedReader r = new BufferedReader(new FileReader(fileName))) {
            while (r.ready()) {
                String s = r.readLine();
                for (int i = 0; i < s.length(); i++) {
                    System.out.print(s.substring(s.length()-i-1, s.length()-i));
                }
                System.out.println("");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
