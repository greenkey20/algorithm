package com.baekjoon.lv2silver.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022.12.21(수) 8h5 v1 -> 9h array index out of bounds exception
public class Main1051 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 주어지는 수 직사각형의 행의 개수/세로 길이
        int M = Integer.parseInt(firstLine[1]); // 직사각형의 열의 개수/가로 길이

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(br.readLine());
        }

        int[][] numbers = new int[N][M];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Character.getNumericValue(sb.charAt(idx));
                idx++;
            }
        }
        System.out.println(Arrays.deepToString(numbers));
        // 이상 입력받은 수들을 N * M 크기의 int형 배열에 담음

        // 문제 해결 로직

        // 출력
        System.out.println(getLargestSquare(N, M, numbers));
    }

    public static int getLargestSquare(int N, int M, int[][] numbers) {
        int smaller = N;
        int bigger = M;

        if (M < N) {
            smaller = M;
            bigger = N;
        }

        int result = 1;

        /* 2022.12.22(목) 23h45 입/출력예시5로 디버깅 -> 가로/세로로 긴 직사각형 경우 나눠야 할 것 같음..
        2022.12.23(금) 0h30 현재 버전으로 제대로 동작 안 함 + 정사각형이 작아질 때 상하좌우로 모두 움직이도록 구현하지 않음
         */
        if (N < M) {
            for (int i = smaller; i > 1; i--) {
                for (int j = 0; j <= bigger - smaller; j++) {
                    int topLeft = numbers[smaller - i][j];
                    int topRight = numbers[smaller - i][j + smaller - 1];
                    int bottomLeft = numbers[i - 1][j];
                    int bottomRight = numbers[i - 1][j + smaller - 1];

                    if (topLeft == topRight && topRight == bottomLeft && bottomLeft == bottomRight) {
                        return i * i;
                    }
                }
            }
        } else {
            for (int i = smaller; i > 1; i--) {
                for (int j = 0; j <= bigger - i; j++) {
                    int topLeft = numbers[j][smaller - i];
                    int topRight = numbers[j + smaller - 1][smaller - i];
                    int bottomLeft = numbers[j][i - 1];
                    int bottomRight = numbers[j + smaller - 1][i - 1];

                    if (topLeft == topRight && topRight == bottomLeft && bottomLeft == bottomRight) {
                        return i * i;
                    }
                }
            }
        }

        return result;
    }
}
