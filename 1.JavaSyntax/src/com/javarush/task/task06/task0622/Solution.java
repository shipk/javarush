package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static ArrayList<Integer> a = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        inputA();
        sortA();
        printA();
    }

    public static void inputA() throws IOException {
        for (int i = 0; i < 5; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            a.add(n);
        }
    }

    public static void sortA() {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                if (a.get(j) < a.get(i)) {
                    int t = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, t);
                }
            }
        }
    }

    public static void printA() {
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i));
            if (i<a.size()-1)
                System.out.println("");
        }
    }
}
