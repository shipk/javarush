package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fis = new FileInputStream(fileName);
        Map<Integer, Long> map = new HashMap<Integer, Long>();
        while (fis.available() > 0) {
            int b = fis.read();
            Long cnt;
            if (map.containsKey(b))
                cnt = map.get(b);
            else
                cnt = new Long(0);
            map.put(b, ++cnt);
        }
        fis.close();
        //System.out.println(map);

        long min = 256;
        for (long it : map.values()) {
            if (it < min)
                min = it;
        }
        for (int b: map.keySet()) {
            if (map.get(b) == min)
                System.out.print(b + " ");
        }
    }
}
