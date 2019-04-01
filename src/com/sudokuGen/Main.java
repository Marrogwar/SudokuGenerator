package com.sudokuGen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int size = sc.nextInt();
        // Generating Sudoku
        Sudoku sudo = new Sudoku(size);
        sudo.generate(size);
        System.out.print("Sudoku: \n");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(sudo.Sudoku[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
