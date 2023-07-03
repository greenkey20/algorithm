package com.baekjoon.lv2silver.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023.7.2(일) 16h50
// ~ 16h55 모든 경우의 수를 탐색하지는 않는 초안 작성 후, 알고리즘 책에서 동적 프로그래밍에 대해 읽기 시작
public class Main1463 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 문제 해결 로직
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

        // 결과 출력
        System.out.println(count);
    }
}
