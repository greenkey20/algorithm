package com.baekjoon.lv2silver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 2023.4.13(목) 22h15
// reference = https://st-lab.tistory.com/110
public class Main11650 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력 받기
        // 위치가 같은 두 점은 없다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] inputs = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] points = br.readLine().split(" ");
            inputs[i][0] = Integer.parseInt(points[0]);
            inputs[i][1] = Integer.parseInt(points[1]);
        }

        // 문제 해결
        sortIntArrays(inputs);

        // 출력 = 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] input = inputs[i];
            sb.append(Arrays.toString(input)).append("\n");
        }

        System.out.println(sb);
    }

    public static void sortIntArrays(int[][] inputs) {
        Arrays.sort(inputs, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                // x좌표가 증가하는 순으로 정렬
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else { // x좌표가 같으면 y좌표가 증가하는 순으로 정렬
                    return e1[1] - e2[1];
                }
            }
        });
    }
}
