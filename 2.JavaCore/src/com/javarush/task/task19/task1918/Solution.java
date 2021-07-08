package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fineName = reader.readLine();
        reader.close();
        String fineName = "c:/tmp/2.txt";

        //String tag = args[0];
        String tag = "span";
        StringBuilder builder = new StringBuilder("");

        FileReader fileReader = new FileReader(fineName);
        while (fileReader.ready()) {
            builder.append((char)fileReader.read());
        }
        fileReader.close();

        String buf = builder.toString();
        //System.out.println(buf);

        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < buf.length()) {
            //System.out.println("zxc: " + i);
            if (isOpenTag(buf, i, tag)!=0) {
                queue.add(i);
                i += isOpenTag(buf, i, tag);
                continue;
                //System.out.println("zxc: " + queue);
            }
            if (isCloseTag(buf, i, tag) != 0) {
                stack.push(i);
                i += isCloseTag(buf, i, tag);

                if (stack.size() == queue.size()) {
                    while (stack.size() > 0) {
                        int start = queue.remove();
                        int end = stack.pop() + 3 + tag.length();
                        System.out.println(buf.substring(start, end));
                    }
                }
                continue;
            }
            i++;
        }
    }

    private static int isOpenTag(String buf, int i, String tag) {
        Pattern pattern = Pattern.compile("^\\<"+tag+"\\s*.*?\\>");
        Matcher matcher = pattern.matcher(buf.substring(i));
        if (matcher.find()) {
            //System.out.println("zxc: " + buf.substring(i, i+matcher.end()));
            return matcher.end();
        }
        return 0;
    }

    private static int isCloseTag(String buf, int i, String tag) {
        Pattern pattern = Pattern.compile("^\\</"+tag+"\\s*.*?\\>");
        Matcher matcher = pattern.matcher(buf.substring(i));
        if (matcher.find()) {
            //System.out.println("zxc1: " + buf.substring(i, i+matcher.end()));
            return matcher.end();
        }
        return 0;
    }
}
