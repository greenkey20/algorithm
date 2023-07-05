package com.baekjoon.lv2silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2023.7.5(수) 11h20 ~ 12h10 v1 원하는 대로 동작 안 함
public class Main1003 {
    public static int[] dp;
    public static int n;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 -> 각 테스트 케이스 n은 40보다 작거나 같은 자연수 또는 0

        // 문제 해결 로직
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            dp[0] = 0;

            if (n > 0) {
                dp[1] = 1;
            }

            int numOfCall0 = 1;
            int numOfCall1 = 0;

            fibonacci(n);
            System.out.println(Arrays.toString(dp));

            if (n > 0) {
                numOfCall0 = dp[n - 1];
                numOfCall1 = dp[n];
            }

            sb.append(numOfCall0).append(" ").append(numOfCall1).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        // 문제를 더 작은 단위로 나눌 수 없는 경우
        /*
        if (n == 0) {
            return dp[n];
        }

        if (n == 1) {
            return dp[n];
        }
         */

        // 문제를 더 작은 단위로 나눌 수 있는 경우
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                dp[n] = dp[n - 1] + dp[n - 2];
            }
        }
//        return fibonacci(n - 1) - fibonacci(n - 2);
//        return dp[n];
    }
}
