package com.nspointers;

import java.util.Arrays;

public class GoldmineProblem {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {3,5,7,8,2},
                {1,2,3,4,5},
                {3,9,5,8,1},
                {5,9,1,5,7},
                {1,6,9,3,4}
        };
        int finalResult = getMaximumGold(arr);
        System.out.println("Final Result is = "+finalResult);
    }

    private static int getMaximumGold(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for(int row=0;row<dp.length;row++){
            for(int col=dp[0].length-1; col>=0; col--){
                if(col == dp[0].length-1){
                    dp[row][col] = arr[row][col];
                }else if(row == 0){
                    dp[row][col] = arr[row][col] + Math.max(dp[row][col+1], dp[row+1][col+1]);
                }else if(row == dp.length-1){
                    dp[row][col] = arr[row][col] + Math.max(dp[row-1][col+1], dp[row][col+1]);
                }else{
                    dp[row][col] = arr[row][col] + Math.max(Math.max(dp[row][col+1],dp[row+1][col+1]),dp[row-1][col+1]);
                }
            }
        }
        System.out.println("Final dp matrix is "+ Arrays.deepToString(dp));
        int max = dp[0][0];
        for (int i = 0; i < dp.length; i++) {
            int item = dp[i][0];
            if(item>max){
                max = item;
            }
        }
        return max;
    }

}
