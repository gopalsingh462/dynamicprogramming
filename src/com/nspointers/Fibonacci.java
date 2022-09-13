package com.nspointers;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        main3(args);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] qb = new int[n + 1];
        int result = fibonacci_memoization(n, qb);
        System.out.println(result);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = fibonacci(n);
        System.out.println(result);
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] qb = new int[n + 1];
        prefeedQuestionBank(qb);
        int result = fibonacci_tabulation(n, qb);
        System.out.println(result);
    }

    /**
     * Bruteforce solution
     * @param n
     * @return
     */
    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int preceding1 = fibonacci(n - 1);
        int preceding2 = fibonacci(n - 2);
        return preceding1 + preceding2;
    }

    /**
     * Recursive solution with memoization
     * @param n
     * @param qb
     * @return
     */
    private static int fibonacci_memoization(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int preceding1 = fibonacci_memoization(n - 1, qb);
        int preceding2 = fibonacci_memoization(n - 2, qb);
        int result = preceding1 + preceding2;
        qb[n] = result;
        return result;
    }

    private static void prefeedQuestionBank(int[] qb) {
        int n = qb.length - 1;
        if (n >= 2) {
            qb[0] = 0;
            qb[1] = 1;
        }
    }

    /**
     * Iterative solution with memoization
     * @param n
     * @param qb
     * @return
     */
    private static int fibonacci_tabulation(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        for (int i = 2; i <= n; i++) {
            qb[i] = qb[i - 1] + qb[i - 2];
        }
        return qb[n];
    }
}
