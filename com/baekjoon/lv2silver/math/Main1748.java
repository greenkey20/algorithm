package com.baekjoon.lv2silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

// 2022.12.19(월) 18h55 입/출력 예시(각 1/2/3자리 수 입력) 가지고 종이에 써보며 패턴 찾고자 함 -> 19h15 맞았습니다!
public class Main1748 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        // 문제 해결 로직

        // 출력
        System.out.println(lengthOfNewNum(N));
    }

    public static int lengthOfNewNum(String N) {
        int lengthOfN = N.length();
        int numN = Integer.parseInt(N);

        int lengthOfNewNum = 0;

        for (int i = lengthOfN; i > 0; i--) {
            if (i != lengthOfN) {
                lengthOfNewNum += 9 * Math.pow(10, i - 1) * i;
            } else {
                lengthOfNewNum += (numN - Math.pow(10, i - 1) + 1) * i;
            }
        }

        return lengthOfNewNum;
    }
}
