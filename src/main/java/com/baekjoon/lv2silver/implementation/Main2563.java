package com.baekjoon.lv2silver.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 2023.1.5(목) 7h30 ~ 8h25 draft1 작성 = 입/출력 예시에 대해 의도한대로 결과 안 나옴
public class Main2563 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfPaper = Integer.parseInt(br.readLine());

        int[][] bottomLefts = new int[numOfPaper][2];

        for (int i = 0; i < numOfPaper; i++) {
            String[] bottomLeft = br.readLine().split(" ");

            for (int j = 0; j < bottomLeft.length; j++) {
                bottomLefts[i][j] = Integer.parseInt(bottomLeft[j]);
            }
        }
        System.out.println(Arrays.deepToString(bottomLefts));

        // 문제 해결 로직

        // 출력
        System.out.println(calculateAreaOfPaper(numOfPaper, bottomLefts));
    }

    public static int calculateAreaOfPaper(int numOfPaper, int[][] bottomLefts) {
        int result = numOfPaper * 10 * 10;
        int overlappedArea = 0;

//        int[][] overlappedPoints = new int[numOfPaper - 1][numOfPaper - 1];
        List<Integer[][]> overlappedPoints = new ArrayList<>();

        // x좌표 오름차순으로 정렬
        Arrays.sort(bottomLefts, Comparator.comparingInt((int[] o) -> o[0]));
        System.out.println(Arrays.deepToString(bottomLefts));

        for (int i = 1; i < numOfPaper; i++) {
            int prevLeft = bottomLefts[i - 1][0];
            int prevRight = prevLeft + 10;

            int thisLeft = bottomLefts[i][0];
            int thisRight = thisLeft + 10;

            int overlappedX = 0;
            if (prevLeft < thisLeft && thisLeft < prevRight) {
                overlappedX = prevRight - thisLeft;
            }

            int prevBottom = bottomLefts[i - 1][1];
            int prevTop = prevBottom + 10;

            int thisBottom = bottomLefts[i][1];
            int thisTop = thisBottom + 10;

            int overlappedY = 0;
            if (prevBottom < thisTop && thisTop < prevTop) {
                overlappedY = thisTop - prevBottom;
            } else if (prevBottom < thisBottom && thisBottom < prevTop) {
                overlappedY = prevTop - thisBottom;
            }

            overlappedArea = overlappedArea - overlappedX * overlappedY;
        }

        return result;
    }
}
