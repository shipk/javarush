package com.javarush.task.task04.task0441;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Как-то средненько
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

        if (i1 <= i2 && i2 <= i3)
            System.out.println(i2);
        else if (i2 <= i1 && i1 <= i3)
            System.out.println(i1);
        else if (i1 <= i3 && i3 <= i2)
            System.out.println(i3);
        else if (i3 <= i2 && i2 <= i1)
            System.out.println(i2);
        else if (i3 <= i1 && i1 <= i2)
            System.out.println(i1);
        else if (i2 <= i3 && i3 <= i1)
            System.out.println(i3);
        else
            System.out.println(i1);
    }
}
