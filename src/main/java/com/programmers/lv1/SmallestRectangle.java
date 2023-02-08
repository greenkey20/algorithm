package com.programmers.lv1;

public class SmallestRectangle {
    // 2023.2.9(목) 2h35 풀이 시작 -> 2h45 맞았습니다
    public static int solution(int[][] sizes) {
        for (int i = 0; i < sizes.length; i++) {
            int left = sizes[i][0];
            int right = sizes[i][1];

            if (left < right) {
                int temp = left;
                sizes[i][0] = right;
                sizes[i][1] = temp;
            }
        }

        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < sizes.length; i++) {
            int left = sizes[i][0];
            int right = sizes[i][1];

            if (left > maxLeft) {
                maxLeft = left;
            }

            if (right > maxRight) {
                maxRight = right;
            }
        }

        return maxLeft * maxRight;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[][](new int[]{60, 50}, new int[]{30, 70}, new int[]{60, 30}, new int[]{80, 40};)));
    }
}
