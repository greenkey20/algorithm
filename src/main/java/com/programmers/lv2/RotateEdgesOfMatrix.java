package com.programmers.lv2;

import java.util.Arrays;

// 2023.3.3(금) 23h25 ~ 23h50 v1 완성 못함
public class RotateEdgesOfMatrix {
    static int[][] matrix;

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = columns * i + j + 1;
//                System.out.print(matrix[i][j] + " "); // todo
            }
//            System.out.println(); // todo
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public static int rotate(int[] query) {
        int min = 0;

        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int memory = matrix[y1][x2];
        int past = 0;

        for (int i = x1; i < x2; i++) {
            int temp = matrix[y1][i + 1];
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
    }
}
