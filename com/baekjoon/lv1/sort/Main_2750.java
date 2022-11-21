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
     */
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기 = 1번째 줄에 정렬 대상 수의 개수(n, 1 <= n <= 1000) + 2번째 줄부터 n개의 줄에는 정수(절대값이 1000 이하, 중복x)가 주어짐
        // 2022.11.21(월) 0h10 v1 = Scanner로 입력받기 -> 맞았습니다 344ms
        /*
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
         */

        // 2022.11.21(월) 12h35 v2 = 좀 더 효율적인 입력 방식 BufferedReader 사용해서 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
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

        // 문제에서 요구하는 출력 = 1~n번째 줄에 오름차순으로 정렬한 결과를 1줄에 숫자 1개씩 출력
        // 2022.11.21(월) 13h40 v2 = 좀 더 효율적인 출력 방식1 -> 맞았습니다 144ms
//        StringBuilder sb = new StringBuilder();

        // 2022.11.21(월) 13h50 v3 = 좀 더 효율적인 출력 방식2 -> 맞았습니다 152ms
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i : arr) {
//            System.out.println(i);
//            sb.append(i).append("\n");

            bw.write(String.valueOf(i)); // 그냥 i를 출력하면 '틀렸습니다'
            bw.newLine();
        }
//        System.out.println(sb);

        br.close();
        bw.flush();
        bw.close();
    }
}
