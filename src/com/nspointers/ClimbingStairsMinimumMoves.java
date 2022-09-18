package com.nspointers;

import java.util.Scanner;

public class ClimbingStairsMinimumMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of N");
        int n = scanner.nextInt();
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter "+(i+1)+ " Element");
            steps[i] = scanner.nextInt();
        }
        Integer result = countMinimumMoves(n,steps);
        if(result != null) {
            System.out.println("Final Result is " + result);
        }else{
            System.out.println("No ways");
        }
    }

    private static Integer countMinimumMoves(int n, int[] steps){
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int numberOfJumps = steps[i];
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=numberOfJumps && i+j < dp.length;j++){
                Integer element = dp[i+j];
                if(element!=null && dp[i+j] < min){
                    min = dp[i+j];
                }
            }
            if(min != Integer.MAX_VALUE) {
                dp[i] = min+1;
            }
        }
        return dp[0];
    }
}
