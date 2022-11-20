package com.baekjoon.lv1.sort;

import java.io.*;

// 2022.10.9(일) 9h
public class Main_2750 {
    /* 정렬의 가장 기초적인 문제
    지금까지는 풀이법(에 대한 설명)을 읽으며 이해하려고 했었는데, 2022.11.20(일) 11h 일단 풀이법별 코드 타이핑하며 흐름을 익히자

    references
    https://st-lab.tistory.com/105
    https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-2750-%EC%88%98-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-java

    방법1) bubble 정렬
    정렬1) 선택 정렬 = 구현하기 가장 쉬움, 시간 복잡도 O(n^2)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        // 반복문 활용한 출력 대신, 하나의 문자열로 이어 한 번에 출력해주면 더 좋은 성능 얻을 수 있음
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
