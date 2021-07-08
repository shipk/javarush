package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        //String fileName = "c:/tmp/4.txt";

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            String s = reader.readLine();
            System.out.println(s);

            Pattern pattern = Pattern.compile("^([^0-9]+) ([0-9]+ [0-9]+ [0-9]+)$");
            Matcher matcher = pattern.matcher(s);
            matcher.find();

            String name = matcher.group(1);
            DateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = format.parse(matcher.group(2));

            Person person = new Person(name, birthDate);
            PEOPLE.add(person);
        }

        reader.close();

/*
        for (int i = 0; i < PEOPLE.size(); i++) {
            System.out.println(PEOPLE.get(i).getName() + " | " +PEOPLE.get(i).getBirthDate());
        }
*/

    }
}
