package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        String option = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        try {
            FileInputStream fis = new FileInputStream(fileName);
            FileOutputStream fos = new FileOutputStream(fileOutputName);
            int b;
            if (option.equals("-e")) {
                while ((b = fis.read()) != -1) {
                    fos.write((byte)b+(byte)1);
                }
            } else if (option.equals("-d")) {
                while ((b = fis.read()) != -1) {
                    fos.write((byte)b-(byte)1);
                }
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
