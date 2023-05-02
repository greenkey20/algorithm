package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2023.5.2(화) 23h50
public class Main16564 {
    public static int n;
    public static int k;
    public static int[] levels;

    public static void main(String[] args) {

    }

    public static int baekjoonIO() throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer ts = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(ts.nextToken()); // 캐릭터의 개수
        k = Integer.parseInt(ts.nextToken()); // 올릴 수 있는 레벨 총합

        levels = new int[n];

        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        return binarySearch(levels);
    }

    public static int binarySearch(int[] levels) {
        int result = 0;
        return result;
    }
}
