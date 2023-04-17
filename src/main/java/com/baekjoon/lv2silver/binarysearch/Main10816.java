package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.4.17(월) 19h5 ~ 19h20 이분탐색 없이 문제 풀이 로직은 작성했는데(입/출력 예시 ok), 시간 초과될 듯.. -> 시간 초과됨
public class Main10816 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 가지고 있는 카드들의 개수

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] cardsAtHand = new int[n]; // 가지고 있는 카드에 적힌 숫자들
        while (st1.hasMoreTokens()) {
            for (int i = 0; i < n; i++) {
                cardsAtHand[i] = Integer.parseInt(st1.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine()); // 가지고 있는 카드에 적힌 숫자와 비교대조할 숫자들의 개수

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] numsToCheck = new int[m]; // 비교대조할 숫자들
        while (st2.hasMoreTokens()) {
            for (int i = 0; i < m; i++) {
                numsToCheck[i] = Integer.parseInt(st2.nextToken());
            }
        }

        // 문제 해결 로직
        Arrays.sort(cardsAtHand);
//        Arrays.sort(numsToCheck);

        int[] counts = new int[m];

        for (int i = 0; i < m; i++) {
            int numToCheck = numsToCheck[i];

            for (int j = 0; j < n; j++) {
                int cardAtHand = cardsAtHand[j];
                if (cardAtHand == numToCheck) {
                    counts[i]++;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int count = counts[i];
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}
