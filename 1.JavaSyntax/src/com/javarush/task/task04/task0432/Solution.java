package com.javarush.task.task04.task0432;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Хорошего много не бывает
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        String sn = bufferedReader.readLine();

        int n = Integer.parseInt(sn);

        int i = 1;
        while (i<=n) {
            System.out.println(s);
            i++;
        }

    }
}
