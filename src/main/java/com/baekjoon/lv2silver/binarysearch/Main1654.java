package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.4.17(월) 18h40 ! 18h55 v1 틀렸습니다 = 최대의 answer가 안 나옴
// Main2805와 비슷한 문제로 추천받음
public class Main1654 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = 0; // 가지고 있는 랜선의 수
        int n = 0; // n개의 answer 길이의 랜선으로 자르고자 함
        while (st.hasMoreTokens()) {
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        }

        int[] lines = new int[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine()); // 각 랜선의 길이는 2^31-1보다 작거나 같은 자연수
        }

        System.out.println("가지고 있는 랜선의 수 k = " + k + ", n개의 랜선으로 만들고자 함 = " + n + ", lines 배열 = " + Arrays.toString(lines)); // todo

        // 문제 해결 로직
        Arrays.sort(lines);

        int left = 0;
        int right = lines[k - 1];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int numOfLines = 0;

            for (int i = 0; i < k; i++) {
                int line = lines[i];

                numOfLines = numOfLines + line / mid;
            }

            if (numOfLines == n) {
                answer = mid;
                break;
            } else if (numOfLines < n) {
                right = mid / 2;
            } else {
                left = mid + 1;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}
