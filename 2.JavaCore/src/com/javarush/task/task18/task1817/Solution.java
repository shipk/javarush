package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        int cntSpaces = 0;
        try (FileReader fr = new FileReader(args[0])) {
            int b;
            while (fr.ready()) {
                b = fr.read();
                char c = (char) b;
                if ( Character.isWhitespace(c))
                    cntSpaces++;
                cnt++;
            }
        }
        if (cnt != 0)
            System.out.printf("%.2f",  (double)cntSpaces * 100 / cnt);
    }
}
