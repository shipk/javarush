package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        //String fileName = "c:/tmp/1.txt";

        int worldCnt = 0;
        int charCnt = 0;
        FileReader f = new FileReader(fileName);
        while (f.ready()) {
            int c = f.read();
            if (charCnt != -1)
                charCnt++;
            //System.out.println((char)c + " " + charCnt);
            if (charCnt != -1) {
                if ((charCnt == 1) && ((char)c == 'w')) continue;
                if (charCnt == 2 && (char)c == 'o') continue;
                if (charCnt == 3 && (char)c == 'r') continue;
                if (charCnt == 4 && (char)c == 'l') continue;
                if (charCnt == 5 && (char)c == 'd') continue;;
                //System.out.println("aa "+charCnt);
                if (charCnt == 6 && isPunktuation((char)c)) {
                    worldCnt ++;
                }
                charCnt = -1;
            }
            if (isPunktuation((char)c)) {
                charCnt = 0;
            }
        }
        if (charCnt == 5)
            worldCnt++;
        f.close();
        System.out.println(worldCnt);
    }

    private static boolean isPunktuation(char c) {
        if (Pattern.matches("[^A-Za-z0-9]", "" + c)) {
            return true;
        }
        return false;
    }
}
