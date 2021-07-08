package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream memoryStream = new PrintStream(stream);
        PrintStream fileStream = new PrintStream(new FileOutputStream(fileName));
        PrintStream consoleStream = System.out;
        System.setOut(memoryStream);
        testString.printSomething();
        System.setOut(consoleStream);
        fileStream.print(stream.toString());
        consoleStream.print(stream.toString());
        fileStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

