package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        //String fileName1 = "c:/tmp/3.txt";
        //String fileName2 = "c:/tmp/4.txt";

        BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> list1 = new ArrayList<String>();
        while (br1.ready()) {
            list1.add(br1.readLine());
        }
        br1.close();

        BufferedReader br2 = new BufferedReader(new FileReader(fileName2));
        ArrayList<String> list2 = new ArrayList<String>();
        while (br2.ready()) {
            list2.add(br2.readLine());
        }
        br2.close();

        int i1 = 0;
        int i2 = 0;
        while (i1 < list1.size() || i2 < list2.size()) {
            String current1 = "";
            if (i1 < list1.size()) {
                current1 = list1.get(i1);
            }
            String current2 = "";
            if (i2 < list2.size()) {
                current2 = list2.get(i2);
            }
            String next1 = "";
            if (i1+1 < list1.size()) {
                next1 = list1.get(i1+1);
            }
            String next2 = "";
            if (i2+1 < list2.size()) {
                next2 = list2.get(i2+1);
            }
            //System.out.println(i1 + " " + i2 + " current1=" + current1 + " current2=" + current2);
            if (current1.equals(current2)) {
                lines.add(new LineItem(Type.SAME, current1));
                i1++;
                i2++;
            } else if (current1.equals(next2)) {
                lines.add(new LineItem(Type.ADDED, current2));
                i2++;
            } else if (current2.equals(next1)) {
                lines.add(new LineItem(Type.REMOVED, current1));
                i1++;
            }
        }
/*
        for (int i = 0; i < lines.size() ; i++) {
            System.out.println(lines.get(i).type + " " + lines.get(i).line);
        }
*/
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
