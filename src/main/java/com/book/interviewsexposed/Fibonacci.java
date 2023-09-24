package com.book.interviewsexposed;

// 2023.9.24(일) 13h45
public class Fibonacci {

    // 방법1) 재귀
    /**
     * 피보나치 수열의 n번째 값을 반환하는 메서드를 작성하라.
     * @param n
     * @return
     */
    public static int nthFibonacciByRecursion(int n) {
        // 재귀 탈출 조건 = 문제를 더 쪼갤 수 없는 경우
        if (n <= 1) return n;

        // 문제를 더 작은 단위로 쪼갤 수 있는 경우
        return nthFibonacciByRecursion(n - 1) + nthFibonacciByRecursion(n - 2);
    }

    // 방법2) memoization
    public static int nthFibonacciByMemoization(int n) {
        return 0;
    }
}
