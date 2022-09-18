package com.nspointers;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCostMaze {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter number of rows");
//        int rows = scanner.nextInt();
//        System.out.println("Enter number of columns");
//        int columns = scanner.nextInt();
//        int[][] matrix = new int[rows][columns];
//        for(int i = 0;i<rows;i++){
//            for(int j=0; j<columns; j++){
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {0, 2, 1, 5, 8},
                {0, 7, 5, 2, 6},
                {1, 2, 5, 9, 9},
                {1, 4, 6, 8, 9}
        };
        int result = minimumCost(matrix);
        System.out.println("Final result is " + result);
    }

    private static int minimumCost(int[][] originalMatrix) {
        int rows = originalMatrix.length;
        int columns = originalMatrix[0].length;
        int rowIndex = rows - 1;
        int columnIndex = columns - 1;
        int[][] dp = new int[rows][columns];
        for (int i = rowIndex; i >= 0; i--) {
            for (int j = columnIndex; j >= 0; j--) {
                if(i==rowIndex && j==columnIndex){
                    dp[i][j] = originalMatrix[i][j];
                }else if(i==rowIndex){
                    dp[i][j] = dp[i][j+1] + originalMatrix[i][j];
                }else if(j==columnIndex){
                    dp[i][j] = dp[i+1][j] + originalMatrix[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + originalMatrix[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
