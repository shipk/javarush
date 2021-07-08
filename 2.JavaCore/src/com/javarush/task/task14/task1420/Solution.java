package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        if (i1<=0)
            throw new Exception("dd");
        int i2 = Integer.parseInt(reader.readLine());
        if (i2<=0)
            throw new Exception("dd");
        int d=1;
        for (int i = 2; i <= (i1<i2? i1:i2) ; i++) {
            if (i1 % i == 0 && i2 % i == 0)
                d = i;
        }
        System.out.println(d);
    }
}
