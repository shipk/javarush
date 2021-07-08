package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        int dx = Math.abs(x1-x2);
        int dy = Math.abs(y1-y2);

        return Math.sqrt(dx*dx + dy*dy);
    }

    public static void main(String[] args) {

    }
}
