package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        String option = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        List<String> list = readFile(fileName);
        ListIterator<String> iter = list.listIterator();
        while(iter.hasNext()) {
            String line = iter.next();
            String id = line.substring(0, line.indexOf(' '));
            if (id.equals(args[0])) {
                System.out.print(line);
            }
        }

    }

    private static List<String> readFile(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String s;
        while ((s = reader.readLine()) != null) {
            list.add(s);
        }
        reader.close();
        return list;
    }

}
