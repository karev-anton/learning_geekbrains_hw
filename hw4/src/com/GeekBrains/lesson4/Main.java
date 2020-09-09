package com.GeekBrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main  {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static boolean checkWin(char symb) {
        int chain_x=1;
        int chain_y=1;
        int chain_z=1;
        int chain_f=1;


        // проверка цепочки по оси Х
        for (int i = map.length-1; i>=0; i--) {
            for (int j = map.length-1; j >0; j--) {
                if (map[i][j]==map[i][j-1]&&map[i][j]!=DOT_EMPTY)
                {
                    chain_x++;
                    if (chain_x==DOTS_TO_WIN) return true;
                }
                else
                {
                    chain_x=1;
                }
            }
        }

        // проверка цепочки по оси Y
        for (int i = map.length-1; i>=0; i--) {
            for (int j = map.length-1; j >0; j--) {
                if (map[j][i]==map[j-1][i]&&map[j][i]!=DOT_EMPTY)
                {
                    chain_y++;
                    if (chain_y==DOTS_TO_WIN) return true;
                }
                else
                {
                    chain_y=1;
                }
            }
        }

        // проверка главной диагонали
        for (int i = map.length-1, j=map.length-1; i>0&&j>0; i--,j--) {
                if (map[i][j]==map[i-1][j-1]&&map[i][j]!=DOT_EMPTY)
                {
                    chain_z++;
                    if (chain_z==DOTS_TO_WIN) return true;
                }
                else
                {
                    chain_z=1;
                }
        }

        // проверка побочной диагонали
        for (int i = map.length-1,j=map.length-i-1; i>0; i--,j= map.length-i-1) {
                if (map[i][j]==map[i-1][j+1]&&map[i][j]!=DOT_EMPTY)
                {
                    chain_f++;
                    if (chain_f==DOTS_TO_WIN) return true;
                }
                else
                {
                    chain_f=1;
                }
        }
        return false;

//OLD STATIC CODE
//        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;

    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x=0, y=0;
        int chain_x=1;
        do {

// нужно как то раздавать веса ходам, времени если честно не хватило, причем вариант с цепочками как выше реализовал не очень подходит,
// т.к. вепочка без центра не соберется, но при этом следюущий ход может быть выиграшный ;(

                        x = rand.nextInt(SIZE);
                        y = rand.nextInt(SIZE);


        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}