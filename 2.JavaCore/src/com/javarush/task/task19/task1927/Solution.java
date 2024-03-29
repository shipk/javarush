package com.javarush.task.task19.task1927;

import java.io.*;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(buff);
        PrintStream consoleStream = System.out;
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String[] lines = buff.toString().split("\\n");
        int i = 0;
        for (String line : lines) {
            i++;
            System.out.println(line);
            if (i % 2 == 0)
                System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

}
