package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        /*
        1) если номер начинается с '+', то он содержит 12 цифр
        2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        */
        int len;
        if (telNumber.matches("^\\+.*")) {
            len = 12;
        }
        else
            len = 10;
        int cnt = 0;
        for (char c : telNumber.toCharArray()) {
            if (c >= '0' && c <= '9')
                cnt++;
        }
        if (cnt != len) {
            debug("\tlen cnt=" + cnt);
            return false;
        }

        /* 3) может содержать 0-2 знаков '-', которые не могут идти подряд */
        if (telNumber.matches(".*--.*")) {
            debug("\t--");
            return false;
        }
        cnt = 0;
        for (char c : telNumber.toCharArray()) {
            if (c == '-')
                cnt++;
        }
        if (cnt > 2) {
            debug("\tmor than 2 hythons");
            return false;
        }

        /* 4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-' */
        if (telNumber.matches(".*\\(.*") && !telNumber.matches(".*\\(.*\\).*")) {
            debug("\tnot a pair of brackets");
            return false;
        }
        if (telNumber.matches(".*\\).*\\(.*")) {
            debug("\tmore than a pair of brackets");
            return false;
        }
        if (telNumber.matches(".*\\-.*[\\(\\)].*")) {
            debug("\t-(");
            return false;
        }

        /* 5) скобки внутри содержат четко 3 цифры */
        if (telNumber.matches(".*\\(.*\\).*") && !telNumber.matches(".*\\(\\d{3,3}\\).*")) {
            debug("\t(123)");
            return false;
        }

        /* 6) номер не содержит букв */
        if (!telNumber.matches("^\\+{0,1}[\\d\\(\\)\\-]+$")) {
            debug("\tletters");
            return false;
        }

        /* 7) номер заканчивается на цифру */
        if (!telNumber.matches("^.*\\d$")) {
            debug("\tlast digit");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }

    public static void debug(String s) {
        //System.out.println(s);
    }
}
