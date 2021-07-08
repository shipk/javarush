package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        //String fileName = "c:/tmp/3.txt";

        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new HashMap<String, Double>();
        while (fr.ready()) {
            String s = fr.readLine();
            Scanner sc = new Scanner(s);
            sc.useLocale(Locale.ENGLISH);
            sc.useDelimiter(" ");
            String name = sc.next();
            Double sal = sc.nextDouble();
            sc.close();
            //System.out.println(name + " " + sal);

            Double sal0 = 0.0;
            if (map.containsKey(name)) {
                sal0 = map.get(name);
            };
            map.put(name, sal + sal0);
        }
        fr.close();

        List<Double> list = new ArrayList<Double>(map.values());
        Collections.sort(list);
        List<String> names = new ArrayList<String>(map.keySet());
        Collections.sort(names);
        for (String nm: names) {
            //System.out.println("zxc: " + nm + " " + map.get(nm));
            if (map.get(nm) == (double)list.get(list.size()-1)) {
                System.out.println(nm);
            }
        }
        //System.out.println(map);
    }
}
