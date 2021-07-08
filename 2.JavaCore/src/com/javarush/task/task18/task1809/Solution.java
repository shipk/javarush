package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
            String fn1 = reader.readLine();
            String fn2 = reader.readLine();
            reader.close();
/*
            String fn1 = "c:/tmp/aa.txt";
            String fn2 = "c:/tmp/bb.txt";
*/
            FileInputStream fis1 = new FileInputStream(fn1);
            Stack<Integer> stack = new Stack<Integer>();
            while (fis1.available()>0) {
                stack.push(fis1.read());
            }
            fis1.close();

            FileOutputStream fis2 = new FileOutputStream(fn2);
            while (stack.size() > 0) {
                fis2.write(stack.pop());
            }
            fis2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
