package com.javarush.task.task19.task1917;

import java.io.*;

/* 
Свой FileWriter
*/

public class FileConsoleWriter{
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public static void main(String[] args) {

    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            System.out.print(cbuf[off+i]);
        }
        fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        System.out.print(c);
        fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        System.out.print(str);
        fileWriter.write(str);
    }

    public void write(String str, int off, int len) throws IOException {
        System.out.print(str.substring(off, off+len));
        fileWriter.write(str, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        for (int i = 0; i < cbuf.length; i++) {
            System.out.print(cbuf[i]);
        }
        fileWriter.write(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

}
