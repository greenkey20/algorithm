package com.baekjoon.lv1.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022.11.28(월) 11h15 -> 11h25 제출 시 틀렸습니다 = num1, num2를 출력할 필요 없는데, 실수로 출력함
public class Main_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        int step1 = 0;
        int step2 = 0;
        int step3 = 0;

        step1 = num1 * (num2 % 10);
        step2 = num1 * (num2 / 10 % 10);
        step3 = num1 * (num2 / 10 / 10);

        int product = num1 * num2;

//        System.out.println(num1);
//        System.out.println(num2);
        System.out.println(step1);
        System.out.println(step2);
        System.out.println(step3);
        System.out.println(product);
    }
}
