package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (FileInputStream fis1 = new FileInputStream(fileName1);
             FileOutputStream fos2 = new FileOutputStream(fileName2);
            )
        {
            PrintStream ps = new PrintStream(fos2);
            while (fis1.available() > 0) {
                int b = fis1.read();
                if ( b != ' ') {
                    bos.write(b);
                } else {
                    if (bos.size() > 0) {
                        double d = Math.round(Double.parseDouble(bos.toString()));
                        ps.printf("%.0f ", d);
                    }
                    bos = new ByteArrayOutputStream();
                }
            }
            if (bos.size() > 0) {
                double d = Math.round(Double.parseDouble(bos.toString()));
                ps.printf("%.0f", d);
            }
        }
    }
}
