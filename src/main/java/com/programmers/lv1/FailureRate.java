package com.programmers.lv1;

import java.util.Arrays;

// 2023.3.30(목) 23h45
public class FailureRate {
    public static int[] solution(int n, int[] stages) {
        int[] answer = new int[n];
        int[] counts = new int[n];

        Arrays.sort(stages);
        System.out.println("오름차순으로 정렬된 배열 stages = " + Arrays.toString(stages)); // todo

        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];

            for (int j = 1; j <= n; j++) {
                if (stage == j) {
                    counts[i]++;
                }
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}))); // 3, 4, 2, 1, 5
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4}))); // 4, 1, 2, 3
    }
}
