package com.baekjoon.lv2silver.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 2023.6.22(목) 17h15 ~ 17h35 v1 문제점 = VPS 안의 VPS가 곱셈으로 묶여야 하는지, 덧셈으로 묶여야 하는지, 처리 안 함 -> e.g. (()[[]])([]) = 42 = (2 * (3 * 3))  * 2 + 3 * 2
public class Main2504 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ps = br.readLine();

        // 문제 해결 로직
        int result = 0;
        int sum = 1;
        Stack<Character> stack = new Stack<>();

        for (int i = ps.length() - 1; i >= 0; i--) {
            char ch = ps.charAt(i);

            if (ch == ')' || ch == ']') {
                stack.push(ch);
            } else { // ch가 여는 괄호(( 또는 ])일 때
                char top = stack.peek(); // 현재 스택의 가장 위에 있는 원소가 뭔지 확인

                if (top == ')' && ch == '(') {
                    sum *= 2;
                    stack.pop();
                } else if (top == ']' && ch == '[') {
                    sum *= 3;
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result += sum;
                    sum = 1;
                }
            }
        }

        if (!stack.empty()) result = 0;

        // 결과 출력
        System.out.print(result);
    }
}
