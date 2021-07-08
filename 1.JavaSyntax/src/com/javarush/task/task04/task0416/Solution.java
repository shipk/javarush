package com.javarush.task.task04.task0416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        double t = Double.parseDouble(s);
        System.out.println(get(t));
    }
    public static String get(double t) {
        Double d = t;
        //System.out.println("d="+d);
        //System.out.println("d.intValue()=="+d.intValue());

        double r = t - 5.0 * (d.intValue()/5);
        //System.out.println("d="+d);
        if (r < 3.0)
            return "зелёный";
        else if (r < 4.0)
            return "жёлтый";
        else
            return "красный";
    }
}