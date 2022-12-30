package com.baekjoon.lv1bronze.math;

import java.io.*;

// 2022.12.12(월) 23h35 "구현" 문제 풀이 -> 23h55 제출 시 맞았습니다(단, 구현 코드에 반복 너무 많아서 리팩토링 필요) -> 성능 차이는 없으나 코드 반복을 줄여 간결하게 만든 v2 = 0h15 맞았습니다
public class Main1110 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 문제 해결 로직

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(cycleOfSums(N)));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int cycleOfSums(int N) {
        // v2 생각해보니 아래 조건문 필요 없음 <- 1자리 자연수를 10으로 나눈 몫은 어쨌든 0
        /*
        if (N < 10) {
            right = N;
        } else {
            left = N / 10;
            right = N % 10;
        }
         */
        int count = 1;
        int newN = getNewN(N);

        while (newN != N) {
            newN = getNewN(newN); // vs N(값이 고정된 수)에 대해 getNewN()을 호출하면 무한루프에 빠짐
            count++;
        }

        return count;
    }

    public static int getNewN(int N) {
        int left = N / 10;
        int right = N % 10;

        int sum = left + right;
        N = right * 10 + sum % 10;

        return N;
    }
}
