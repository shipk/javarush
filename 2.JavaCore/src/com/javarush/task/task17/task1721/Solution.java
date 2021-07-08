package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            //fileName1 = "c:\\tmp\\aa.txt";
            //fileName2 = "c:\\tmp\\bb.txt";

            readFile(fileName1, allLines);
            readFile(fileName2, forRemoveLines);

            List<String> savedLines = new ArrayList<>(allLines);
            try {
                (new Solution()).joinData();
            } catch (CorruptedDataException e) {
                allLines = savedLines;
            }

            //printData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void readFile(String fileName, List<String> list) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = reader.readLine()) != null)
            list.add(s);
        reader.close();
    }

    public synchronized void joinData() throws CorruptedDataException {
        for (String removedLine : forRemoveLines) {
            if (!allLines.removeIf(b -> b.equals(removedLine))) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }

    public static void printData() {
        for (String s: allLines) {
            System.out.println(s);
        }
    }
}
