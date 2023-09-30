package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.5.2(화) 23h50 ~ 2023.5.3(수) 0h15 문제 분류는 이분탐색인데, 무엇을 이분탐색해야 하는 건지 잘 모르겠다
public class Main16564 {
    public static int n;
    public static int k;
    public static int[] levels;

    // main() 함수
    public static void main(String[] args) throws IOException {
        // 문제 풀이 solution 호출
        presentSolution(baekjoonIO());
    }

    // 데이터 입력받기
    public static int baekjoonIO() throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 캐릭터의 개수
        k = Integer.parseInt(st.nextToken()); // 올릴 수 있는 레벨 총합

        levels = new int[n];

        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        return binarySearch(levels);
    }

    // 결과 출력
    public static void presentSolution(int result) {
        System.out.println(result);
    }

    // 문제 해결 logic
    public static int binarySearch(int[] levels) {
        Arrays.sort(levels);
        System.out.println("levels 배열 = " + Arrays.toString(levels)); // todo

        int result = 0;

        int left = levels[0];
        int right = levels[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
        }

        return result;
    }
}
