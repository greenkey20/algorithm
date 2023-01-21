package com.programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InverseTrinaryDigit {
    // 2023.1.20(금) 2h30 -> 2h50 입/출력 예시대로 동작하는 듯
    public static int solution(int n) {
        // 몫이 0이 될 때까지 n을 3으로 나눔 + 나머지를 스택에 차례차례 담음 -> 나머지 스택에서 하나씩 꺼내어 3진수를 만듦 -> 3진수를 앞뒤로 뒤집음 -> 이를 10진법으로 표현
        int quotient = n; // 3으로 나눈 몫
//        Stack<Integer> remainders = new Stack<>(); // list에 바로 담아서 앞뒤 반전 3진법을 바로 만들 수도 있음
        List<Integer> remainders = new ArrayList<>();

        while (quotient > 0) {
            quotient = n / 3;
            remainders.add(n % 3);
            n = quotient;
        }

//        System.out.println(remainders);

        int decimalDigit = 0;
        for (int i = remainders.size() - 1; i >= 0; i--) {
            decimalDigit += (int) Math.pow(3.0, i) * remainders.get(remainders.size() - i - 1);
        }

        return decimalDigit;
    }

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));

        System.out.println(solutionReference(45));
        System.out.println(solutionReference(125));
    }

    // 다른 사람들의 풀이 = Integer.parseInt(정수로 바꿀 숫자를 문자열로 쓴 것, 왼쪽 숫자가 몇 진수인지) 활용
    public static int solutionReference(int n) {
        String remainders = "";

        while (n > 0) {
            remainders = remainders + n % 3;
            n /= 3; // n = n / 3;
            System.out.println("n = " + n + ", remainders = " + remainders);
        }

        /* Params:
            s – the String containing the integer representation to be parsed
            radix – the radix to be used while parsing s
        Returns: the integer represented by the string argument in the specified radix
         */
        return Integer.parseInt(remainders, 3);
    }
}
