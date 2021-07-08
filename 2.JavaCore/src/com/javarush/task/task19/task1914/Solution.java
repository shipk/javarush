package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        PrintStream consoleSteam = System.out;
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleSteam);

        Pattern pattern = Pattern.compile("^([0-9]+) (.) ([0-9]+) ");
        Matcher matcher = pattern.matcher(outputStream.toString());
        matcher.find();
        //System.out.println(outputStream.toString());
        //System.out.println(matcher.group(1));
        int result = 0;

        if (matcher.group(2).equals("+") ) {
            result = Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3));
        } else if (matcher.group(2).equals("-") ) {
            result = Integer.parseInt(matcher.group(1)) - Integer.parseInt(matcher.group(3));;
        } else if (matcher.group(2).equals("*") ) {
            result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(3));;
        }

        System.out.println(outputStream.toString() + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

