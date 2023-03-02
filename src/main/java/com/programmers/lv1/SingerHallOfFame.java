package com.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingerHallOfFame {
    // 2023.3.2(목) 22h30 ~ 23h15 맞았습니다
    public static int[] solution(int k, int[] score) {
        int numOfDays = score.length;
        int[] answer = new int[numOfDays];

        for (int i = 1; i <= numOfDays; i++) {
            int[] scores = new int[i];

            for (int j = 0; j < i; j++) {
                scores[j] = score[j];
            }

            Arrays.sort(scores);
            // System.out.println(i + "번째 날의 전체 점수 오름차순 = " + Arrays.toString(scores)); // todo

            if (i <= k) {
                answer[i - 1] = scores[0];
            } else {
                answer[i - 1] = scores[i - k];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}))); // [10, 10, 10, 20, 20, 100, 100]
        System.out.println(Arrays.toString(solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}))); // [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
    }
}
