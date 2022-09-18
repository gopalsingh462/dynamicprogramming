package com.nspointers;

import java.util.Scanner;

public class ClimbingStairsVariableStep {
    public static void main(String[] args) {
        int n = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of n");
        n = scanner.nextInt();
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i + 1) + " element");
            steps[i] = scanner.nextInt();
        }
        int result = countPaths(n, steps);
        System.out.println("Final Result = "+result);
    }

    private static int countPaths(int n, int[] steps) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int numberOfSteps = steps[i];
            for(int j=1; j<=numberOfSteps && i+j < dp.length ;j++){
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
    }
}
