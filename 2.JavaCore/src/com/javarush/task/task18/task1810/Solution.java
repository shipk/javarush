package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Stack;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try {
            BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
            while (true) {
                String fn1 = reader.readLine();

                FileInputStream fis1 = new FileInputStream(fn1);

                if (fis1.available() < 1000) {
                    fis1.close();
                    throw new DownloadException();
                }
                fis1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}
