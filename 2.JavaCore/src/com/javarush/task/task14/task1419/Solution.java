package com.javarush.task.task14.task1419;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new NullPointerException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new IOException());
        exceptions.add(new FileAlreadyExistsException("a"));
        exceptions.add(new EOFException());
        exceptions.add(new IllegalAccessException());
        exceptions.add(new ClassCastException());
        exceptions.add(new ClassNotFoundException());

    }
}
