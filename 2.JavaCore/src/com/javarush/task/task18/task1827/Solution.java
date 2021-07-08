package com.javarush.task.task18.task1827;

import java.io.*;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        String option = args[0];
        if (option.equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            int maxId = getMaxId(fileName);

            String productName = args[1];
            String price = args[2];
            String quantity = args[3];
            FileOutputStream fos = new FileOutputStream(fileName, true);
            PrintStream ps = new PrintStream(fos);
            ps.printf("\n%-8d%-30s%-8s%-4s", maxId + 1, productName, price, quantity);
            ps.close();
            fos.close();
        }
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
