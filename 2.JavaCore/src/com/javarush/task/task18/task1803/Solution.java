package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
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

        long max = 0;
        for (long it : map.values()) {
            if (it > max)
                max = it;
        }
        for (int b: map.keySet()) {
            if (map.get(b) == max)
                System.out.print(b + " ");
        }
    }
}
