package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.4.17(월) 19h5 ~ 19h20 이분탐색 없이 문제 풀이 로직은 작성했는데(입/출력 예시 ok), 시간 초과될 듯.. -> 시간 초과됨
// ~ 19h30 v2 의도하는대로 동작x
// 2023.4.19(수) 0h20 reference https://st-lab.tistory.com/267 학습 -> 이 문제에서처럼 탐색 대상에 중복 있을 경우 왜 현재 내 코드로 안 되는지 이해 못하고 있음 -> 0h50 어제 작성한 코드의 논리적 오류를 깨닫고 수정해봤는데, 중복 요소들을 못 센다..?
// -> 1h 중복 요소들에 대해 실행 흐름 손으로 써보니 이해 = 현재 알고리즘은 일단 해당 값이 탐색 대상 배열에 있는 것을 확인하면 그 인덱스(mid)를 반환 + 그 값이 더 있는지 찾을 필요 없음
public class Main10816 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 가지고 있는 카드들의 개수

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] cardsAtHand = new int[n]; // 가지고 있는 카드에 적힌 숫자들
        while (st1.hasMoreTokens()) {
            for (int i = 0; i < n; i++) {
                cardsAtHand[i] = Integer.parseInt(st1.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine()); // 가지고 있는 카드에 적힌 숫자와 비교대조할 숫자들의 개수

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] numsToCheck = new int[m]; // 비교대조할 숫자들
        while (st2.hasMoreTokens()) {
            for (int i = 0; i < m; i++) {
                numsToCheck[i] = Integer.parseInt(st2.nextToken());
            }
        }

        // 문제 해결 로직
        Arrays.sort(cardsAtHand);
//        Arrays.sort(numsToCheck);
        System.out.println(Arrays.toString(cardsAtHand)); // todo

        int[] counts = new int[m];

        for (int i = 0; i < m; i++) {
            int numToCheck = numsToCheck[i];

            // v2 binary search
            // numToCheck가 cardsAtHand에 있는지 없는지 이분탐색을 한다 -> 있으면 counts[i]++
            if (binarySearch(cardsAtHand, numToCheck) >= 0) {
                counts[i]++;
            }

            // v1 시간 초과
            /*
            for (int j = 0; j < n; j++) {
                int cardAtHand = cardsAtHand[j];
                if (cardAtHand == numToCheck) {
                    counts[i]++;
                }
            }
             */
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int count = counts[i];
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int[] cardsAtHand, int numToCheck) {
        int left = 0;
        int right = cardsAtHand.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (numToCheck < cardsAtHand[mid]) {
                right = mid - 1;
            } else if (numToCheck > cardsAtHand[mid]) {
                left = mid + 1;
            } else {
                System.out.println(numToCheck + "은 탐색 대상 배열의 인덱스" + mid + "에 있다"); // todo
                return mid;
            }
        }

        System.out.println(numToCheck + "은 탐색 대상 배열에 없다"); // todo
        return -1;
    }

}
