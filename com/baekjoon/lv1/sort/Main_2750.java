package com.baekjoon.lv1.sort;

import java.io.*;
import java.util.Scanner;

// 2022.10.9(일) 9h
public class Main_2750 {
    /* 정렬의 가장 기초적인 문제
    지금까지는 풀이법(에 대한 설명)을 읽으며 이해하려고 했었는데, 2022.11.20(일) 11h 일단 풀이법별 코드 타이핑하며 흐름을 익히자

    references
    https://st-lab.tistory.com/105
    https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-2750-%EC%88%98-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-java

    방법1) bubble 정렬

    방법2) 선택 정렬 = 구현하기 가장 쉬움, 시간 복잡도 O(n^2)
    2022.11.21(월) 0h10 v1 = Scanner로 입력받기
     */
    public static void main(String[] args) {
        // 데이터 입력받기
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 선택 정렬 알고리즘 구현
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    // arr[i]와 arr[j]의 자리 바꾸기
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
