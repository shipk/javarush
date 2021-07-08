package com.javarush.task.task04.task0417;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Существует ли пара?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String s3 = bufferedReader.readLine();

        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        int n3 = Integer.parseInt(s3);

        if (n1 == n2 && n2 == n3)
            System.out.println(s1 + " " + s2 + " " + s3);
        else if (n1 == n2)
            System.out.println(s1 + " " + s2);
        else if (n1 == n3)
            System.out.println(s1 + " " + s3);
        else if (n2 == n3)
            System.out.println(s2 + " " + s3);
    }
}