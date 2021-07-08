package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int n = 0;
        while (true) {
            String s = bufferedReader.readLine();
            int i = Integer.parseInt(s);
            if (i == -1)
                break;
            sum += i;
            n++;
        }
        System.out.println(1.0 * sum / n);

    }
}

