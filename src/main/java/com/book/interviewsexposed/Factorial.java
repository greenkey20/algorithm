package com.book.interviewsexposed;

// 2023.9.25(월) 12h
public class Factorial {

    /**
     * 재귀적 방법을 사용하지 않는 팩토리얼 구현을 작성하라.
     * @param n
     * @return
     */
    public static long factorialByLoop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
