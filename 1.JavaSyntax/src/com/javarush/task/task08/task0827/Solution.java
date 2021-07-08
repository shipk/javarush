package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.*;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        date = date.substring(0,1) + date.substring(1).toLowerCase();
        SimpleDateFormat formatter = new SimpleDateFormat("MMM d yyyy", Locale.ENGLISH);
        Date dt = formatter.parse(date);

        int day = Integer.parseInt((new SimpleDateFormat("D")).format(dt));

        return day % 2 != 0;
    }
}
