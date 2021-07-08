package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        String option = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if (option.equals("-c")) {

            int maxId = getMaxId(fileName);

            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            FileOutputStream fos = new FileOutputStream(fileName, true);
            PrintStream ps = new PrintStream(fos);
            ps.printf("\n%-8d%-30s%-8s%-4s", maxId + 1, productName, price, quantity);
            ps.close();
            fos.close();
        } else if (option.equals("-d")) {
            List<String> list = readFile(fileName);
            ListIterator<String> iter = list.listIterator();
            while(iter.hasNext()) {
                if (iter.next().substring(0, 8).trim().equals(args[1])) {
                    iter.remove();
                }
            }
            writeFile(fileName, list, false);
        } else if (option.equals("-u")) {
            List<String> list = readFile(fileName);
            ListIterator<String> iter = list.listIterator();
            while(iter.hasNext()) {
                if (iter.next().substring(0, 8).trim().equals(args[1])) {
                    String s = String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]);
                    iter.set(s);
                }
            }
            writeFile(fileName, list, false);
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

    private static void writeFile(String fileName, List<String> list, boolean append) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName, append);
        PrintStream ps = new PrintStream(fos);
        int i = 0;
        for (String line : list) {
            String cr = (i==0? "":"\n");
            ps.printf("%s%s", cr, line);
            i++;
        }
        ps.close();
        fos.close();
    }

    private static int getMaxId(String fileName) throws IOException {
        int maxId = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                //System.out.println(line.length());
                int id = Integer.parseInt(line.substring(0, 8).trim());
                if (maxId < id) maxId = id;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
        }
        return maxId;
    }
}
