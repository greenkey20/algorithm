package com.baekjoon.lv2silver.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 2023.4.11(화) 21h30
public class Main2751 {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /*
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // v1 시도 = 21h45 맞았습니다
        Arrays.sort(arr);
         */

        // 문제 해결 = 정렬
        // 문제2750에서 구현한 선택 정렬 알고리즘 제출하면 '시간 초과로 틀렸습니다'
        // 문제2750과 다른 점 = 정렬해야 하는 수의 개수 및 크기(절대값 1,000,000 이하)
        /* reference = https://st-lab.tistory.com/106
        Collections.sort() = hybrid 정렬 알고리즘 Timsort (https://en.wikipedia.org/wiki/Timsort) = 합병 정렬 + 삽입 정렬 = 시간복잡도 O(n) ~ O(nlogn) 보장
         */
        // v2 Collections.sort() 사용
        /*
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
         */

        // v3 counting/계수 정렬 구현해보기 -> 22h20 제출 시 런타임 에러(ArrayIndexOutOfBounds), 음수 입력 값 때문에..?
        // reference = https://st-lab.tistory.com/104
        /* 22h25 수정할 점 according to the reference(106)
        1. 정렬 대상 수가 중복되지 않기 때문에, boolean[] 배열에 입력받은 값을 index로 쓰면 됨
        2. 수의 범위가 -1,000,000 ~ 1,000,000 -> 0 기준을 인덱스 1,000,000으로 잡음

        22h45 맞았습니다 = 계수 정렬에서는 정렬 대상 수의 범위만큼의 배열 및 정렬되는 배열 따로 만드는데(저장공간 2개 추가), Arrays.sort()나 Collections.sort()와 메모리 차이가 크게 안 나는 것은 왜일까?
         */
        int[] notSorted = new int[n]; // 문제에서 주어지는, 정렬해야 하는, 배열
//        int[] counts = new int[1000001]; // 정렬 대상 수의 범위
        boolean[] counts = new boolean[1000000 * 2 + 1];
        List<Integer> arr = new ArrayList<>(); // 정렬되는 배열/list

        // step0) 정렬 대상 배열 입력받기
        for (int i = 0; i < n; i++) {
            notSorted[i] = Integer.parseInt(br.readLine());
        }

        // step1) 정렬해야 하는 배열에서 값을 하나하나 뽑고, 그 수를 인덱스로 갖는 counts의 방에 넣음 = notSorted 원소들의 출현 횟수
        for (int i = 0; i < notSorted.length; i++) {
            counts[notSorted[i] + 1000000] = true;
        }

        // step2) counts 배열의 내용물을 누적합으로 바꿔줌 = 정렬 대상으로써 중복 입력 없으므로, 이 과정 필요 없음
        /*
        for (int i = 1; i < counts.length; i++) {
//            counts[i] = counts[i] + counts[i - 1];
            counts[i] += counts[i - 1];
        }
         */

        // step3) arr에 정렬시키기
        /*
        for (int i = notSorted.length - 1; i >= 0; i--) {
            int num = notSorted[i];

            arr[counts[num] - 1] = num;
            counts[num]--;
        }
         */
        for (int i = 0; i < counts.length; i++) {
            if (counts[i]) {
                arr.add(i - 1000000);
            }
        }

        // 출력 = 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i : arr) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 일반 계수 정렬 알고리즘
    public int[] countingSort(int[] notSorted) { // 매개변수 = 문제에서 주어지는, 정렬해야 하는, 배열
        int[] counts = new int[1000001]; // 정렬 대상 수의 범위
        int[] sorted = new int[notSorted.length]; // 정렬되는 배열/list

        // step1) 정렬해야 하는 배열에서 값을 하나하나 뽑고, 그 수를 인덱스로 갖는 counts의 방에 넣음 = notSorted 원소들의 출현 횟수
        for (int i = 0; i < notSorted.length; i++) {
            counts[notSorted[i]]++;
        }

        // step2) counts 배열의 내용물을 누적합으로 바꿔줌 = 정렬 대상으로써 중복 입력 없으므로, 이 과정 필요 없음
        for (int i = 1; i < counts.length; i++) {
//            counts[i] = counts[i] + counts[i - 1];
            counts[i] += counts[i - 1];
        }

        // step3) arr에 정렬시키기
        for (int i = notSorted.length - 1; i >= 0; i--) {
            int num = notSorted[i];

            sorted[counts[num] - 1] = num;
            counts[num]--;
        }

        return sorted;
    }
}
