package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream original) {
        this.original = original;
    }

    public void flush() throws IOException {
        original.flush();
    }

    public void write(int b) throws IOException {
        original.write(b);
    }

    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    public void close() throws IOException {
        original.flush();
        original.write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }
}

