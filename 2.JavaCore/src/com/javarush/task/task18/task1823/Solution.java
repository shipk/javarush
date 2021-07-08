package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> fileNames = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("exit")) break;
            fileNames.add(fileName);
        }
        reader.close();

        ArrayList<ReadThread> threads = new ArrayList<ReadThread>();
        for (String fileName: fileNames) {
            ReadThread thread = new ReadThread(fileName);
            thread.start();
            threads.add(thread);
        }

        for (ReadThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            int bytes[] = new int[256];
            try (FileInputStream fis = new FileInputStream(fileName)) {
                while (fis.available() > 0) {
                    bytes[fis.read()]++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int maxInd = 0;
            int max = 0;
            for (int i = 0; i < 255; i++) {
                if (bytes[i] > max) {
                    max = bytes[i];
                    maxInd = i;
                }
            }
            synchronized(this.getClass()) {
                resultMap.put(fileName, maxInd);
            }
        }
    }
}
