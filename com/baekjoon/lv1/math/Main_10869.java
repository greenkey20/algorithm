package com.baekjoon.lv1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022.11.28(월) 11h v1 입력 양식을 정수 2개로 제대로 받지 못해서 runtime number format error 발생 -> https://help.acmicpc.net/judge/rte/NumberFormat 참고
public class Main_10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        System.out.println(A + B);
        System.out.println(A - B);
        System.out.println(A * B);
        System.out.println(A / B);
        System.out.println(A % B);

        br.close();
    }
}
