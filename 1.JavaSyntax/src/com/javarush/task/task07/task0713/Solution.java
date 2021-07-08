package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> inp = new ArrayList<Integer>();
        ArrayList<Integer> del3 = new ArrayList<Integer>();
        ArrayList<Integer> del2 = new ArrayList<Integer>();
        ArrayList<Integer> rest = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            Integer n = Integer.parseInt(reader.readLine());
            inp.add(n);
            if (n % 3 == 0)
                del3.add(n);
            if (n % 2 == 0)
                del2.add(n);
            if (n % 3 != 0 && n % 2 !=0)
                rest.add(n);
        }
        printList(del3);
        printList(del2);
        printList(rest);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
