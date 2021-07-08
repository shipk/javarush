package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<Rectangle> list = new ArrayList<Rectangle>();

    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        list = new ArrayList<Rectangle>();

        for (int x = 0; x < a[0].length; x++) {
            for (int y = 0; y < a.length ; y++) {
                if (a[x][y] == 1) {
                    boolean found = false;
                    for (Rectangle r : list) {
                        if (x >= r.x && x < r.x + r.dx && y >= r.y && y < r.y + r.dy) {
                            found = true;
                            break;
                        }
                    }
                    if (found) continue;

                    // new rectangle
                    Rectangle rectangle = new Rectangle(x,y,0,0);
                    for (int i = x; i < a[0].length; i++) {
                        if (a[i][y] != (byte) 1) {
                            break;
                        }
                        rectangle.dx++;
                    }
                    for (int j = y; j < a.length; j++) {
                        if (a[x][j] != 1) {
                            break;
                        }
                        rectangle.dy++;
                    }
                    list.add(rectangle);
                    //System.out.println("new " + rectangle);
                }
            }
        }

        return list.size();
    }

    private static class Rectangle {
        public int x;
        public int y;
        public int dx;
        public int dy;

        public Rectangle(int x, int y, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d) + (%d, %d)", x, y, dx, dy);
        }
    }
}
