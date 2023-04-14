package com.baekjoon.lv1bronze.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2023.4.14(금) 21h50 ~ 22h45 v1 references 보고 썼는데, 코드 이해도 정확히 안 되고, 생각한대로 동작하지 않음
/* 9개 중 7개를 순서없이 뽑는 '조합'
references
https://data-make.tistory.com/467
https://velog.io/@cgw0519/알고리즘-순열-중복순열-조합-중복조합-총정리
https://minhamina.tistory.com/38
 */
public class Main2309 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = new int[9];
        for (int i = 0; i < 9; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 로직
        Arrays.sort(inputs);
        int r = 7;
        boolean[] visited = new boolean[inputs.length];

        StringBuilder sb = new StringBuilder();
        if (combinationDraft(inputs, visited, 0, 0, r)) {
            // 출력
            for (int i = 0; i < inputs.length; i++) {
                if (visited[i]) {
                    sb.append(inputs[i]).append("\n");
                }
            }
            System.out.println(sb);
        }

    }

    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {

    }

    public static boolean combinationDraft(int[] arr, boolean[] visited, int start, int depth, int r) {
        int sum = 0;
        boolean result = false;

        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }

            return sum == 100;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combinationDraft(arr, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }

        return result;
    }
}
