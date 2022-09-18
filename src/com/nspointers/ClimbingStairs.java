package com.nspointers;

import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        main2(args);
    }

    private static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = countWaysRecursive(n, new int[n + 1]);
        System.out.println(result);
    }

    private static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = countWaysIterative(n);
        System.out.println(result);
    }

    /**
     * Iterative solution with tabulation.
     * @param n
     * @return
     */
    private static int countWaysIterative(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2]+ dp[i-3];
        }
        return dp[n];
    }

    /**
     * Recursive solution with memoization
     * @param n
     * @param qb
     * @return
     */
    private static int countWaysRecursive(int n, int[] qb) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int way1 = countWaysRecursive(n - 1, qb);
        int way2 = countWaysRecursive(n - 2, qb);
        int way3 = countWaysRecursive(n - 3, qb);

        int finalResult = way1 + way2 + way3;
        qb[n] = finalResult;
        return finalResult;
    }
}
