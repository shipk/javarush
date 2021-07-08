 package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filename);
        reader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (true) {
            String s = reader.readLine();
            if (s == null)
                break;
            int i = Integer.parseInt(s);
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        reader.close();
        inputStream.close();

        Collections.sort(list);
        for (int i :
                list) {
            System.out.println(i);
        }

    }
}
