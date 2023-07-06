package com.baekjoon.lv2silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023.7.6(목) 19h30 ~ 19h55 테스트 케이스 1개 확인 후 제출 = 틀렸습니다
public class Main2579 {
    //    public static int n;
//    public static int[] scores;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 계단의 개수, 300 이하의 자연수

        int[] scores = new int[n]; // 각 10,000 이하의 자연수
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 로직
        int result = solution(n, scores);

        // 결과 출력
        System.out.println(result);
    }

    public static int solution(int n, int[] scores) {
        int[] dp = new int[n + 1]; // dp[i] = i번째 계단에 도달할 때까지 얻을 수 있는 총 점수의 최대 값
        dp[1] = scores[0];
        int count = 0; // 테스트1은 통과 + 테스트2는 통과x

        for (int i = 2; i <= n; i++) {
            int score1stepBehind = dp[i - 1];
            int score2stepsBehind = dp[i - 2];
            int scoreOfThisStep = scores[i - 1];

            if (count > 0) {
                dp[i] = score2stepsBehind + scoreOfThisStep;
                count = 0;
            } else {
                if (score1stepBehind > score2stepsBehind) {
                    dp[i] = score1stepBehind + scoreOfThisStep;
                    count++;
                } else {
                    dp[i] = score2stepsBehind + scoreOfThisStep;
                }
            }

//            dp[i] = Math.max(dp[i - 1], dp[i - 2]) + scores[i - 1];
        }

        return dp[n];
    }
}
