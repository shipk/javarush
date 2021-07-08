package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = reader.readLine();
            boolean parameterFlag = false;
            boolean valueFlag = false;
            String name = "";
            String value = "";
            boolean flagObj = false;
            String flagValue = "";
            for (char c :
                    s.toCharArray()) {
                if (c == '?' || c == '&') {
                    parameterFlag = true;
                    valueFlag = false;
                    if (!name.equals("")) {
                        print(name, value);
                        if (name.equals("obj")) {
                            flagObj = true;
                            flagValue = value;
                        }
                    }
                    name = "";
                    value = "";
                } else if (c == '=') {
                    value = "";
                    parameterFlag = false;
                    valueFlag = true;
                } else if (parameterFlag) {
                    name += c;
                } else if (valueFlag) {
                    value += c;
                }
            }
            if (!name.equals("")) {
                print(name, value);
                if (name.equals("obj")) {
                    flagObj = true;
                    flagValue = value;
                }
            }
            while (flagObj) {
                try {
                    System.out.println("");
                    alert(Double.valueOf(flagValue));
                    break;
                } catch (NumberFormatException e) {
                }
                System.out.println("");
                alert(flagValue);
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(String name, String value) {
        System.out.print(name + " ");
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
