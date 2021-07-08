package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            a.add(reader.readLine());
        }
        int minLen = -1; int minLenIndex = -1;
        int maxLen = -1; int maxLenIndex = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).length() < minLen || minLen == -1) {
                minLen = a.get(i).length();
                minLenIndex = i;
            }
            if (a.get(i).length() > maxLen || maxLen == -1) {
                maxLen = a.get(i).length();
                maxLenIndex = i;
            }
        }
        if (minLenIndex < maxLenIndex)
            System.out.println(a.get(minLenIndex));
        else if (minLenIndex > maxLenIndex)
            System.out.println(a.get(maxLenIndex));
    }
}
