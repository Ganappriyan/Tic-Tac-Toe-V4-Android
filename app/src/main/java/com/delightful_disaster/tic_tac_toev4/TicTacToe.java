package com.delightful_disaster.tic_tac_toev4;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TicTacToe {
    char[] A;
    public char CURRENT_PLAYER_SIGN;
    ArrayList<Byte> availableChoices = new ArrayList<>();
    String[] playerInfo;

    public void driver(int n) {

    }

    protected void initialize() {
        A = new char[]{'\0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        availableChoices.clear();
        for (byte i = 1; i < 10; i++) availableChoices.add(i);
        CURRENT_PLAYER_SIGN = 'X';
    }

    public int noobMove() {
        int move = getRandomElement(availableChoices);
        placeMove(move, CURRENT_PLAYER_SIGN);
        return move;
    }

    public int veteranMove() {
        if (A[5] == '5') {
            placeMove(5, CURRENT_PLAYER_SIGN);
            return 5;
        }
        int move = checkAdjacentPair();
        if (move > 0) {
            if(Math.random()>0.1) {
                ArrayList<Byte> tmpList = availableChoices;
                tmpList.remove(move);
                move = tmpList.get(getRandomElement(tmpList));
            }
            placeMove(move, CURRENT_PLAYER_SIGN);
            return move;
        }
        return noobMove();
    }

    public int proMove() {
        Log.d("MyLog", "Pro Move Called");
        return 0;
    }

    protected int checkWin() {
        if(availableChoices.size()==0) return 1;
        if(all(1, 2, 3) || all(4, 5, 6) || all(7, 8, 9) || all(1, 4, 7) ||
           all(2, 5, 8) || all(3, 6, 9) || all(1, 5, 9) || all(3, 5, 7)) return 2;
        return 0;
    }

    private int checkAdjacentPair() {
        String[] pattern = {"23.59.47", "13.58", "12.57.69", "17.56",
                "19.28.37.46", "39.45", "14.35.89", "25.79", "15.36.78"};
        char[] match = {'X', 'O'};
        for (char c : match) {
            for (int i = 0; i < pattern.length; i++) {
                String[] tmp = pattern[i].split("\\.");
                for (String s : tmp) {
                    int k = Integer.parseInt(s);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (c == A[k % 10] && c == A[k % 100]) {
                        return i + 1;
                    }
                }
            }
        }
        return 0;
    }

    public void placeMove(int move, char sign) {
        A[move] = sign;
        availableChoices.remove(move);
    }

    protected void switchPlayer() {
        CURRENT_PLAYER_SIGN = (CURRENT_PLAYER_SIGN == 'X')? 'O' : 'X';
    }

    private boolean all (int a1, int a2, int a3) {
        return (A[a1] == A[a2] && A[a2] == A[a3]);
    }
    private byte getRandomElement(ArrayList<Byte> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
