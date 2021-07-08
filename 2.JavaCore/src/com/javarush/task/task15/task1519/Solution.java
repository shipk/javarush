package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s.equals("exit"))
                break;
            if (s.contains(".")) {
                try {
                    Double v = Double.valueOf(s);
                    print(v);
                    continue;
                } catch (NumberFormatException e) {
                }
            }
            try {
                Short v = Short.valueOf(s);
                if (v > 0 && v < 128) {
                    print(v);
                    continue;
                }
            } catch (NumberFormatException e) {
            }
            try {
                Integer v = Integer.valueOf(s);
                print(v);
                continue;
            } catch (NumberFormatException e) {
            }
            print(s);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
