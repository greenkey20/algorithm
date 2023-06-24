package com.baekjoon.lv2silver.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2023.6.24(토) 23h40
public class Main2504v2 {
    public class Pair {
        private List<Pair> pairList = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ps = br.readLine();

        // 문제 해결 로직
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < ps.length() - 2; i++) {
            char thisCh = ps.charAt(i);
            char nextCh = ps.charAt(i + 1);

            if (thisCh == '(' || thisCh == '[') { // 금번 확인하는 문자가 여는 괄호인 경우
                stack.push(thisCh);
            } else {
                char top = stack.peek();

                if (top == '(' || thisCh == ')') { // 닫는 괄호인 경우

                    stack.pop();

                }
            }

        }
    }
}
