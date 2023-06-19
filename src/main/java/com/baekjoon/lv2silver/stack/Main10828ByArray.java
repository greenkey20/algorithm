package com.baekjoon.lv2silver.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2023.6.20(화) 0h50 ~ 1h5 draft1(미완성)
// reference = https://st-lab.tistory.com/175
public class Main10828ByArray {
    private static int[] stack;
    private static int size = 0;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 10,000

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            // 문제 해결 로직
            int result = 0;
            switch (command) {
                case "pop":
                    result = pop();
                    sb.append(result).append("\n");
                    break;
                default:
                    push(Integer.parseInt(command.split(" ")[1]));
            }

        }

        // 결과 출력
        System.out.print(sb);
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        }

        size--;
        return stack[size - 1];
    }

    public static int size() {
        return size;
    }

    public static void push(int element) {
        stack[size] = element;
        size++;
    }
}
