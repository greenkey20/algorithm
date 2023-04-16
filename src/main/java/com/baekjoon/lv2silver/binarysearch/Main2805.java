package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2023.4.16(일) 23h10 왜 이분탐색 문제인지 지금은 잘 모르겠다
// 이분탐색 로직 없이 작성한 v1은 입/출력 예시에 따르면 로직은 맞는 것 같은데, 23h25 제출 시 시간 초과 = 각 나무 높이 최대 10억부터 탐색하는 게 시간이 오래 걸리나? 아니면, 이중 for문이라서?
public class Main2805 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");

        int n = Integer.parseInt(line1[0]); // 나무의 수 = 1 ≤ N ≤ 1,000,000
        int m = Integer.parseInt(line1[1]); // 적어도 m미터의 나무를 집에 가져가야 함 = 1 ≤ M ≤ 2,000,000,000

        String[] line2 = br.readLine().split(" ");
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(line2[i]); // 각 나무의 높이 = 1,000,000,000보다 작거나 같은 양의 정수, 또는 0
        }

        // 문제 해결 로직
        Arrays.sort(trees); // 나무들의 크기를 오름차순 정렬
        int answer = 0;

        // 가장 큰 나무부터 작은 나무까지의 수를 1씩 감소시키면서
        for (int i = trees[n - 1]; i >= trees[0]; i--) {
            answer = i;
            int sum = 0;

            for (int j = 0; j < n; j++) {
                int tree = trees[j];

                if (tree >= answer) {
                    sum = sum + tree - i;
                }
            }

            if (sum >= m) {
//                System.out.println();
                break;
            }
        }

        // 출력
        System.out.println(answer);
    }
}
