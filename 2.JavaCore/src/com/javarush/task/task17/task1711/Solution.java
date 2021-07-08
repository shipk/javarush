package com.javarush.task.task17.task1711;


import java.security.spec.RSAOtherPrimeInfo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
/*
        for (Person p :
                allPeople) {
            printPerson(p);
        }
        System.out.println("----------------");
*/

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        allPeople.add(createPerson(args[i], args[i + 1], args[i + 2]));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        int j = Integer.parseInt(args[i]);
                        allPeople.set(j, createPerson(args[i + 1], args[i + 2], args[i + 3]));
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int j = Integer.parseInt(args[i]);
                        Person p = allPeople.get(j);
                        p.setName(null);
                        p.setSex(null);
                        p.setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int j = Integer.parseInt(args[i]);
                        printPerson(allPeople.get(j));
                    }
                }
                break;
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
        System.out.print(p.getName());
        System.out.print(" ");
        if (p.getSex() == null)
            System.out.print("null");
        else
            System.out.print(p.getSex() == Sex.FEMALE? "ж" : "м");
        System.out.print(" ");
        if (p.getBirthDate() == null)
            System.out.print("null");
        else {
            DateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.print(format.format(p.getBirthDate()));
        }
        System.out.println("");
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
