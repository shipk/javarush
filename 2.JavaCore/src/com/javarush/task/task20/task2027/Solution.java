package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //List<Word> list = detectAllWords(crossword, "home", "same", "fsg");
        List<Word> list = detectAllWords(crossword, "same", "rmr", "ema", "err", "emoh", "home", "plgm", "mglp");
        for (Word word : list) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    private static void evaluate(int[][] crossword, List<Word> list, String[] words, int x, int y, int dx, int dy) {
        for (String word : words) {
            //System.out.println("eval x=" + x + " y="+y+" dx="+dx+" dy="+dy);
            int currX = x;
            int currY = y;
            boolean flag = false;
            if (dx == 0 && dy == 0) {
                if (word.length() == 1 && crossword[currY][currX] == (int) word.toCharArray()[0]) {
                    flag = true;
                }
            } else {
                if (word.length() > 1) {
                    flag = true;
                    for (char ch : word.toCharArray()) {
                        if (currX < 0 || currX >= crossword[0].length || currY < 0 || currY >= crossword.length || (int) ch != crossword[currY][currX]) {
                            flag = false;
                            break;
                        }
                        currX += dx;
                        currY += dy;
                        //System.out.print(ch);
                    }
                }
            }
            if (flag) {
                //System.out.println("add");
                Word w = new Word(word);
                w.startX = x;
                w.startY = y;
                w.endX = currX-dx;
                w.endY = currY-dy;
                list.add(w);
            }
        }
    }

    private static void iterate(int[][] crossword, List<Word> list, String[] words) {
        //evaluate(crossword, list, words, 0, 0, 1, 1);

        for (int i = 0; i < crossword[0].length; i++) {
            for (int j = 0; j < crossword.length; j++) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        evaluate(crossword, list, words, i, j, dx, dy);
                    }
                }
            }
        }

    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<Word>();
        iterate(crossword, list, words);
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
