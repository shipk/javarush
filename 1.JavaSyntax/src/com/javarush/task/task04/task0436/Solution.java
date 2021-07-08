package com.javarush.task.task04.task0436;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Рисуем прямоугольник
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sm = bufferedReader.readLine();
        String sn = bufferedReader.readLine();

        int m = Integer.parseInt(sm);
        int n = Integer.parseInt(sn);

        for (int i=0; i<m; i++) {
            for (int j = 0; j<n; j++)
                System.out.print("8");
            System.out.println("");
        }

    }
}
