package com.baekjoon.lv2silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.4.17(월) 19h5 ~ 19h20 이분탐색 없이 문제 풀이 로직은 작성했는데(입/출력 예시 ok), 시간 초과될 듯.. -> 시간 초과됨
// ~ 19h30 v2 의도하는대로 동작x
// 2023.4.19(수) 0h20 reference https://st-lab.tistory.com/267 학습 -> 이 문제에서처럼 탐색 대상에 중복 있을 경우 왜 현재 내 코드로 안 되는지 이해 못하고 있음 -> 0h50 어제 작성한 코드의 논리적 오류를 깨닫고 수정해봤는데, 중복 요소들을 못 센다..?
// -> 1h 중복 요소들에 대해 실행 흐름 손으로 써보니 이해 = 현재 알고리즘은 일단 해당 값이 탐색 대상 배열에 있는 것을 확인하면 그 인덱스(mid)를 반환 + 그 값이 더 있는지 찾을 필요 없음 -> 다른 방법의 풀이가 필요하다?
// 2023.4.21(금) 23h50 위 레퍼런스 읽고, 알고리즘은 이해한 것 같아 구현해 보기로 한다 = lower/upper bound 개념 적용 + 그런데 이런 알고리즘을 떠올리려면 어떻게 해야 할까..? ㅠㅠ -> 0h40 입/출력 예시에 대해서는 탐색 되는데, '틀렸습니다'
// 2023.4.23(일) 22h30 알고리즘 이해를 바탕으로 조금 다시 수정해 봤는데(while문 반복 조건 수정) 여전히 '틀렸습니다', 어떻게 검증/검토해야 좋을까?
public class Main10816 {
    public static int[] cardsAtHand;
    public static int[] lowerBounds;
    public static int[] upperBounds;

    public static void main(String[] args) throws IOException {
        /* 예제 입력1
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
            예제 출력1 = 3 0 0 1 2 0 0 2
         */
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 가지고 있는 카드들의 개수

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        cardsAtHand = new int[n]; // 가지고 있는 카드에 적힌 숫자들
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

        lowerBounds = new int[n];
        upperBounds = new int[n];

        int[] counts = new int[m];

        for (int i = 0; i < m; i++) {
            int numToCheck = numsToCheck[i];

            // v2 binary search
            // numToCheck가 cardsAtHand에 있는지 없는지 이분탐색을 한다 -> 있으면 counts[i]++
//            if (binarySearch(cardsAtHand, numToCheck) >= 0) {
//                counts[i]++;
//            }

            // v3 lower/upper bound 적용
            lowerBounds[i] = lowerBound(numToCheck);
            upperBounds[i] = upperBound(numToCheck);

            counts[i] = upperBounds[i] - lowerBounds[i];

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

    // 2023.4.22(토) 0h15
    public static int lowerBound(int numToCheck) {
        int left = 0;
        int right = cardsAtHand.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // 계산 과정 중 int overflow 발생을 대비하는 코드

            if (numToCheck <= cardsAtHand[mid]) {
                right = mid - 1;
            } else /*if (numToCheck > cardsAtHand[mid])*/ {
                left = mid + 1;
            }

//            if (left == right) {
//                break;
//            }
        }

        return left; // 2023.4.23(일) 22h45 입/출력 예시 10의 lowerBound 탐색을 종이에 써서 하다 보니 left+1을 return해야 하나? 공책에 메모한 고민 과정 참고..
    }

    public static int upperBound(int numToCheck) {
        int left = 0;
        int right = cardsAtHand.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (numToCheck < cardsAtHand[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

//            if (left == right) {
//                break;
//            }
        }

        return left;
    }
}
