package com.programmers.lv1;

public class BottlesOfCoke {
    // 2023.1.26(목) 11h40 -> 11h55 v1 문제 요구사항대로 동작x
    public static int solution(int a, int b, int n) {
        int answer = 0;
        int currentNumOfEmptyBottles = 0;

        while (currentNumOfEmptyBottles >= a) {
            currentNumOfEmptyBottles = n / a + n - (n / a) * a;
            answer = answer + n / a;
            n = currentNumOfEmptyBottles;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20)); // 19
        System.out.println(solution(3, 1, 20)); // 9
    }
}
