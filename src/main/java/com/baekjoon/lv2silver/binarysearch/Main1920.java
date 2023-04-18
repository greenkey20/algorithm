package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2023.4.18(화) 23h45
// 2분탐색 가장 기본적인 문제
public class Main1920 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 탐색 대상 = n개의 정수

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int m = Integer.parseInt(br.readLine()); // arr에 존재하는지 검사할 수들의 개수 = m

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] numsToCheck = new int[m];
        for (int i = 0; i < m; i++) {
            numsToCheck[i] = Integer.parseInt(st2.nextToken());
        }

        // 문제 해결 로직
        // numsToCheck 배열의 원소를 하나하나 체크하며 2분탐색 수행
        for (int i = 0; i < m; i++) {
            int numToCheck = numsToCheck[i];
            int searchResult = binarySearch(arr, numToCheck);
        }

        // 결과 출력
    }

    public static int binarySearch(int[] arr, int numToCheck) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (numToCheck < arr[mid]) {
                right = mid - 1;
            } else if (numToCheck > arr[mid]) {
                left = mid + 1;
            } else {
                return 1;
            }
        }

        return -1;
    }
}
