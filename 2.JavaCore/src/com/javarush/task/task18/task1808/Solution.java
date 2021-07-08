package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
            String fn1 = reader.readLine();
            String fn2 = reader.readLine();
            String fn3 = reader.readLine();
            reader.close();

/*
            String fn1 = "c:/tmp/aa.txt";
            String fn2 = "c:/tmp/bb.txt";
            String fn3 = "c:/tmp/cc.txt";
*/

            FileInputStream fis1 = new FileInputStream(fn1);
            FileOutputStream fis2 = new FileOutputStream(fn2);
            FileOutputStream fis3 = new FileOutputStream(fn3);
            int pos2 = fis1.available()/2 + (fis1.available() - 2*(fis1.available()/2));
            int i = 0;
            while (fis1.available()>0) {
                if (i < pos2) {
                    fis2.write(fis1.read());
                } else {
                    fis3.write(fis1.read());
                }
                i++;
            }
            fis1.close();
            fis2.close();
            fis3.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
