package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fileNames = new ArrayList<String>();

/*
        fileNames.add("c:/tmp/zxc.part1");
        fileNames.add("c:/tmp/zxc.part3");
        fileNames.add("c:/tmp/zxc.part2");
*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("end")) break;
            fileNames.add(fileName);
        }
        reader.close();

        String outFileName = fileNames.get(0);
        outFileName = outFileName.substring(0, outFileName.indexOf(".part"));
        //System.out.println(outFileName);

        // sort
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (getPartNo(o1) < getPartNo(o2)? -1 : 1);
            }

            private int getPartNo(String s) {
                for (int i = s.length()-1; i >= 0 ; i--) {
                    if (!Character.isDigit(s.charAt(i))) {
                        return Integer.parseInt(s.substring(i+1));
                    }
                };
                return 0;
            }
        };
        Collections.sort(fileNames, comparator);


        // merge
        try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(outFileName, false), 200)) {
            for (String fileName : fileNames) {
                try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(fileName), 200)) {
                    while (fis.available() > 0) {
                        fos.write(fis.read());
                    }
                }
            }
        }
    }

}
