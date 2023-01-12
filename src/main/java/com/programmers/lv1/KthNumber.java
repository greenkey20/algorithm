package com.programmers.lv1;

import java.util.Arrays;

public class KthNumber {
    // 2023.1.12(목) 8h5 -> 8h20 IntelliJ에서 입/출력 예시로 테스트 시 ok
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int startIdx = commands[i][0] - 1;
            int endIdx = commands[i][1];
            int[] subArray = Arrays.copyOfRange(array, startIdx, endIdx);
            Arrays.sort(subArray);
            answer[i] = subArray[commands[i][2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
