package com.javarush.task.task04.task0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Сортировка трех чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String s3 = bufferedReader.readLine();

        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i3 = Integer.parseInt(s3);

        int t;

        for (int i = 0; i < 2 ; i++) {
            if (i1>i2) {
                t=i1; i1=i2; i2=t;
            }
            if (i2>i3) {
                t=i2; i2=i3; i3=t;
            }
        }

        System.out.println(i3+" "+i2+" "+i1);

    }

}
