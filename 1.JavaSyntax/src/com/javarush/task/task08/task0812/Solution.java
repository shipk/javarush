package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Cамая длинная последовательность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        int t = list.get(0);
        int n = 1;
        int max = 1;
        for (int i = 1; i < 10; i++) {
            if (t == list.get(i)) {
                n++;
            } else {
                if (n > max) max = n;
                t = list.get(i);
                n = 1;
            }
        }
        if (n > max) max = n;
        System.out.println(max);
    }
}
