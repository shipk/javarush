package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> families = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            cities.add(city);

            String family = reader.readLine();
            if (family.isEmpty()) {
                break;
            }
            families.add(family);
        }

        //System.out.println(cities);
        //System.out.println(families);

        // Read the city name
        String city = reader.readLine();

        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).equals(city))
                System.out.println(families.get(i));
        }

    }
}
