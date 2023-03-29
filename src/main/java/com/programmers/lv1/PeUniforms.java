package com.programmers.lv1;

import java.util.Arrays;

// 2023.3.29(수) 11h25 ~ 11h45 v1 입출력 예시에 대해서는 동작하나, 채점 시 정확성 48.0 = greedy에 대해 추가 읽어보지는 않고 일단 풀어봄
public class PeUniforms {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {
            int lostStudentNum = lost[i];

            for (int j = 0; j < reserve.length; j++) {
                int reserveStudentNum = reserve[j];

                if (lostStudentNum == reserveStudentNum - 1 || lostStudentNum == reserveStudentNum + 1) {
                    //System.out.println(lostStudentNum + "번 학생은 " + reserveStudentNum + "번 학생으로부터 체육복을 빌려입는다"); // todo
                    answer++;
                    lostStudentNum = -1;
                    reserve[j] = 0;
                }
                //System.out.println(Arrays.toString(reserve)); // todo
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // 5
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3})); // 4
        System.out.println(solution(3, new int[]{3}, new int[]{1})); // 2
    }
}
