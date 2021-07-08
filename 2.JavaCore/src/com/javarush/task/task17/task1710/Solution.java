package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
/*
        for (String s: args) {
            System.out.println(s);
        }
        System.out.println("----------------");
*/
        if (args[0].equals("-c")) {
            allPeople.add(createPerson(args[1], args[2], args[3]));
            System.out.println(allPeople.size()-1);
        } else if (args[0].equals("-u")) {
            int i = Integer.parseInt(args[1]);
            allPeople.set(i, createPerson(args[2], args[3], args[4]));
        } else if (args[0].equals("-d")) {
            int i = Integer.parseInt(args[1]);
            Person p = allPeople.get(i);
            p.setName(null);
            p.setSex(null);
            p.setBirthDate(null);
        } else if (args[0].equals("-i")) {
            int i = Integer.parseInt(args[1]);
            printPerson(allPeople.get(i));
        }

/*
        System.out.println("----------------");
        for (Person p :
                allPeople) {
            printPerson(p);
        }
*/
    }

    private static void printPerson(Person p) {
        DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(p.getName() + (p.getSex() == Sex.FEMALE? " ж " : " м ") + format.format(p.getBirthDate()));
    }

    private static Person createPerson(String name, String sex, String date) {
        Person p = null;
        Date dat = null;

        try {
            dat = (new SimpleDateFormat("dd/MM/yyyy")).parse(date);
        } catch (ParseException e) {
            e.getStackTrace();
        }

        if (sex.equals("м")) {
            p = Person.createMale(name, dat);
        } else if (sex.equals("ж")) {
            p = Person.createFemale(name, dat);
        }

        return p;
    }
}
