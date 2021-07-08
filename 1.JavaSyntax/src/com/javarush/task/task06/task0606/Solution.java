package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        while (true) {
            int r = n % 10;

            if (r % 2 == 0)
                even++;
            else
                odd++;
            n = n / 10;
            if (n==0) break;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
