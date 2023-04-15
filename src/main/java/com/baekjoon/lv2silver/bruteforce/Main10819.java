package com.baekjoon.lv2silver.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2023.4.15(토) 22h45 ~ 23h20 맞았습니다
public class Main10819 {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] numsStr = br.readLine().split(" ");
        int[] nums = new int[n]; // 배열 원소들은 -100 ~ 100 범위의 정수

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        // 문제 해결 로직
        /* nums의 원소들로 순열을 만들고, 각 케이스마다 주어진 식의 값을 구함 -> 이 값을 다음 케이스의 식의 값과 비교하며 계속 갱신해나감 -> 그렇게 마지막에 저장된 숫자를 return
         */
        for (int i = 0; i < n; i++) {
            int sum = 0;
        }

        int[] output = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        permutation(nums, output, visited, 0, n, n);

//        int sum = Math.abs(nums[0] - nums[1]) + Math.abs(nums[1] - nums[2]) + Math.abs(nums[2] - nums[3]);

        // 출력
        System.out.println(max);
    }

    /* '순열 자바' 검색해서 https://bcp0109.tistory.com/14 보고 거의 따라침 ㅠㅠ
    순열 재귀 정확히 이해 필요 ㅠㅠ
     */
    public static void permutation(int[] nums, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int sum = 0;

            for (int i = 1; i < r; i++) {
                sum += Math.abs(output[i - 1] - output[i]);
            }

            if (sum > max) {
                max = sum;
            }

            System.out.println("output 배열 = " + Arrays.toString(output) + ", sum = " + sum + ", max = " + max); // todo
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                permutation(nums, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
