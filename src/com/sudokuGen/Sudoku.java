package com.sudokuGen;

import java.util.Random;

public class Sudoku {

        static int[][] Sudoku;
        public Sudoku(int s){
            Sudoku = new int[s][s];
        }


        public static void generate(int size) {
        int elements = size * size;
        int filledElements = 0;
        //filling of array
        while (elements >= filledElements) {
            //take random cell
            int l = RandomValue(size-1);
            int c = RandomValue(size-1);
            //filling with checking
            if (Sudoku[l][c] == 0) {
                Sudoku[l][c] = RandomValue(size, l, c);
                filledElements++;
            } else continue;

        }
    }



    //May be not working
    public static int RandomValue(int s){
        Random random  = new Random(System.currentTimeMillis());
        int value = random.nextInt(s) + 1;
        return value;
    }
    //Random value with checking
    //CHANGE POINT SYSTEM
    public static int RandomValue(int s, int l, int c){
        int passed = 0;
        int value = 0;
        while (passed == 0){
            Random random  = new Random(System.currentTimeMillis());
            value = random.nextInt(s) + 1;
            //lets check
            boolean check = Checking(s, l, c, value);
            if (check) {
                passed = 1;
                break;
            }
            else continue;
        }
        return value;
    }

    public static boolean Checking(int s, int l, int c, int value){
        //boolean isPassed;
        Sudoku[l][c] = value;
        int points = 0;
        //Check line
        for (int col = 0; col < s; col++){
            if (Sudoku[l][col] == Sudoku[l][c]){
                if (col == c) points++;
                else break;
            }
            else points++;
        }
        //Check column
        for (int line = 0; line < s; line++){
            if (Sudoku[line][c] == Sudoku[l][c]){
                if (line == l) points++;
                else break;
            }
            else points++;
        }
        //Check square
        boolean sc = SquareChecking(s, l, c);
        if (sc == true) points++;
        /*if ( points == 3) isPassed = true;
        else isPassed == 0;

        return isPassed;*/
        //Or just change to size*3
        if ( points == (s*3)) return true;
        else {
            Sudoku[l][c] = 0; //if default value is 0 then just step back
            return false;
        }
    }

    public static boolean SquareChecking(int s, int l, int c){
        //boolean squareCheck = true;
        int squareSize = ((Double)(Math.sqrt(s))).intValue(); //may be not working
        int squareHorizontal;
        int squareVertical;
        //Calculting square
        squareHorizontal = (int)(Math.ceil(l/squareSize));
        squareVertical = (int)(Math.ceil(c/squareSize)); //WTF 1/2 = 0;
        //Check in this square
        int squareLineBeg = squareHorizontal * squareSize - squareSize;
        int squareLineEnd = squareHorizontal * squareSize - 1;
        int squareColBeg = squareVertical * squareSize - squareSize;
        int squareColEnd = squareVertical * squareSize - 1;
        //DEBUG THIS
        for (int i = squareLineBeg; i <= squareLineEnd; i++){
                for(int k = squareColBeg; k <= squareColEnd; k++){
                    if (Sudoku[i][k] == Sudoku[l][c]){
                        if ((k == c) && (i == l)) continue;
                        else{
                            //squareCheck = false;
                            //break;
                            return false;
                        }
                    }
                    //if (squareCheck == false) break;
                    return true;
                }
        }
        //return squareCheck;
        return false;
    }
}
