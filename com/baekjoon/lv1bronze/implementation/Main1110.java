package com.baekjoon.lv1bronze.implementation;

import java.io.*;

// 2022.12.12(월) 23h35 -> 23h55 제출 시 맞았습니다(단, 구현 코드에 반복 너무 많아서 리팩토링 필요)
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
        int left = 0;
        int right = 0;

        if (N < 10) {
            right = N;
        } else {
            left = N / 10;
            right = N % 10;
        }

        int sum = left + right;
        int count = 1;
        int newN = right * 10 + sum % 10;

        while (newN != N) {
            left = newN / 10;
            right = newN % 10;
            sum = left + right;

            newN = right * 10 + sum % 10;
            count++;
        }

        return count;
    }
}
