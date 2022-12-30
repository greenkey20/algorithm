package com.baekjoon.lv2silver.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 2022.12.17(토) 7h5
public class Main10773 {
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()); // K개의 정수가 주어짐

        numbers = new int[K];

        for (int i = 0; i < K; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 로직

        // 출력
        System.out.println(calculateZeroAsMistake(numbers));
    }

    public static int calculateZeroAsMistake(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                stack.pop();
            } else {
                stack.add(numbers[i]); // 처음에는 이렇게 스택에 안 쌓아서 empty stack exception 발생
            }
        }

        return stack.stream().mapToInt(num -> num).sum();
    }
}

/* 회고
1. 머리로만 풀지/생각하지 말고, 종이에 연필로 그려보고 써보자 - 내 머리가 문제의 상황을 정확히 그려내지 못한다
2. 입력 양식 너무 겁 먹지 말고, 문제에 맞게 차근차근 쓰면 된다
 */
