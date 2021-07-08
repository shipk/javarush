package com.javarush.task.task10.task1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (true) {
            int i;
            try {
                i = Integer.parseInt(reader.readLine());
            }
            catch (NumberFormatException e) {
                break;
            }
            String s = reader.readLine();
            map.put(s, i);
        }
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            System.out.println(e.getValue() + " " + e.getKey());
        }

    }
}
