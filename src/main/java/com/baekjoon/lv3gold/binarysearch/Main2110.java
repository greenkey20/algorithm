package com.baekjoon.lv3gold.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.4.26(수) 23h45
/* 문제 이해에 시간 걸렸는데, reference https://st-lab.tistory.com/277에 따라 "포인트는 집 간 최소 거리 이상일 때 설치가 가능하다"
 */
public class Main2110 {
    public static int[] houses;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer ts = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(ts.nextToken()); // 집의 개수
        int c = Integer.parseInt(ts.nextToken()); // 공유기의 개수

        houses = new int[n];

        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 로직
        Arrays.sort(houses);

        int left = houses[0];
        int right = houses[n - 1] + 1; // upperBound의 의미를 오늘은 조금 다르게 정의해서 풀어보기로 함

        // 결과 출력
        System.out.println();
    }
}
