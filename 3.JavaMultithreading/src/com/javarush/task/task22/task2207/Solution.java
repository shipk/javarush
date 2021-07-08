package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = "c:/tmp/2207.txt";
        String fileName = reader.readLine();
        reader.close();

        StringBuilder s = new StringBuilder("");
        reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            s.append(reader.readLine());
            s.append(" ");
        }
        reader.close();

        //System.out.println(s.toString());

        String[] words = s.toString().split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(words));
        while (true) {
            boolean found = false;
            for (int i = 0; i < list.size() && !found; i++) {
                StringBuilder s1 = new StringBuilder(list.get(i));
                for (int j = i+1; j < list.size() && !found; j++) {
                    StringBuilder s2 = new StringBuilder(list.get(j));
                    StringBuilder s2Reverse = new StringBuilder(s2);
                    s2Reverse.reverse();
                    //System.out.println(s1.toString() + " : " + s2.toString());
                    if (s1.toString().equals(s2Reverse.toString())) {
                        //System.out.println("zxc : " + s1.toString() + " : " + s2.toString());
                        Pair pair = new Pair();
                        if (s1.toString().compareTo(s2.toString()) > 0) {
                            pair.first = s1.toString();
                            pair.second = s2.toString();
                        } else {
                            pair.second = s1.toString();
                            pair.first = s2.toString();
                        }
                        result.add(pair);
                        list.remove(j);
                        list.remove(i);
                        found = true;
                    }
                }
            }
            if (!found) break;
        }

        for (Pair pair : result) {
            System.out.println(pair.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
