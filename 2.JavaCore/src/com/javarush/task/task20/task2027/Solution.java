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
        List<Word> words = detectAllWords(crossword, "home", "same");
        System.out.println(words.get(0));
        System.out.println(words.get(1));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<Word>();

        int[] dx = {1,-1, 0, 0, 1, -1, 1, -1};
        int[] dy = {0, 0, 1, -1,1, -1, -1, 1};

        for (String word : words) {
            Word objWord = new Word(word);

            char[] symbol = word.toCharArray();

            for (int y = 0; y < crossword.length; y++){
                for (int x = 0; x < crossword[y].length; x++) {
                    if (crossword[y][x] == symbol[0]) {

                        for (int j = 0; j < dx.length; j++) {
                            int a = 0;
                            int b = 0;
                            boolean findWord = true;

                            for (int i = 1; i < symbol.length; i++) {
                                b = y + dy[j] * i;
                                a = x + dx[j] * i;
                                if (b >= crossword.length  || b < 0
                                    || a >= crossword[0].length || a< 0
                                    || crossword[b][a] != symbol[i]) {
                                    findWord = false;
                                    break;
                                }
                            }
                            if (findWord) {
                                objWord.setStartPoint(x, y);
                                objWord.setEndPoint(a, b);
                                list.add(objWord);
                                break;
                            }

                        }


                    }
                }
            }


        }

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
