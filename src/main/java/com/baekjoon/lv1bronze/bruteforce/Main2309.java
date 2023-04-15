package com.baekjoon.lv1bronze.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2023.4.14(금) 21h50 ~ 22h45 v1 references 보고 썼는데, 코드 이해도 정확히 안 되고, 생각한대로 동작하지 않음
/* 9개 중 7개를 순서없이 뽑는 '조합'

references
1. 조합 일반
https://velog.io/@cgw0519/알고리즘-순열-중복순열-조합-중복조합-총정리
https://minhamina.tistory.com/38
2. 문제 풀이
https://data-make.tistory.com/467
https://anott.tistory.com/25
 */
public class Main2309 {
    // v2
    static int n = 9, r = 7, k = 100;
    static int[] dwarfs = new int[n];
    static int[] realDwarfs = new int[r];
    static int[] results = new int[r];
    static boolean ckEnd = false;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 로직
        Arrays.sort(dwarfs);

        // v2 22h50 ~ 23h20 references 보고 일단 써봄
        combination(0, 0, 0);

        // 출력
        for (int i : results) {
            System.out.println(i);
        }

        // v1
        /*
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
         */
    }

    // v2
    /**
     * @param count 현재 이만큼 크기 조합을 만들고 있음
     * @param start dwarfs의 순회 위치
     * @param sum 현재 조합에 뽑힌 dwarfs의 키의 합
     */
    public static void combination(int count, int start, int sum) {
        // 합이 100인 7명 난쟁이를 찾았으니까, 더 이상 진행할 필요 없음
        if (ckEnd) return;

        if (count == r) { // 7명을 뽑은 조합이 되었고
            if (sum == k) { // 7명의 키의 합이 100이면
                // 이 조합을 '답'으로 적어둠
                // Manual array copy = 내가 작성한 것
                /*
                for (int i = 0; i < realMembers.length; i++) {
                    results[i] = realMembers[i];
                }
                 */
                // IntelliJ의 suggestion
                System.arraycopy(realDwarfs, 0, results, 0, realDwarfs.length);

                ckEnd = true;
            }
            return;
        }

        for (int i = start; i < dwarfs.length; i++) {
            realDwarfs[count] = dwarfs[i];
            combination(count + 1, i + 1, sum + dwarfs[i]);
        }
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
