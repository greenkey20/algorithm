package com.baekjoon.lv2silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023.7.7(금) 0h30 문제 읽고 연습장에 메모하며 고민해봄 ~ 0h55 (+2023.7.7(금) 8h30~55) 아직 패턴 못 찾겠음..
public class Main9095 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        // 문제 해결 로직
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int result = solution(n);

            sb.append(result).append("\n");
        }

        // 결과 출력
        System.out.print(sb);
    }

    public static int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;

        int[] elements = {1, 2, 3};

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < elements.length; j++) {
                int el = elements[j];

                if (i > el) {
                    dp[i] += dp[i - el];
                }
            }
        }


        return dp[n];
    }
}
