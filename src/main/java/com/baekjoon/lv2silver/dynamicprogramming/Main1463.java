package com.baekjoon.lv2silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023.7.2(일) 16h50
// ~ 16h55 모든 경우의 수를 탐색하지는 않는 초안 작성 후, 알고리즘 책에서 동적 프로그래밍에 대해 읽기 시작 + 2023.7.4(화) 23h30 레퍼런스들(e.g. https://smartpro.tistory.com/24) 읽어보기
public class Main1463 {
//    public static int[] dp;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 문제 해결 로직
        /*
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else {
                n--;
            }

            count++;
        }
         */

        // 2023.7.5(수) 0h10 동적 프로그래밍 방법으로 풀어보자! -> 테스트 케이스 작성하고 확인 후, 0h40 제출 = 맞았습니다
        int result = solution(n);

        // 결과 출력
        System.out.println(result);

    }

    public static int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i / 3] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp[n];
    }
}
