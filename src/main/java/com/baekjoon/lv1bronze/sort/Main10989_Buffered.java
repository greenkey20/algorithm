package com.baekjoon.lv1bronze.sort;

import java.io.*;

// 2023.4.12(수) 23h35 입/출력 방식 바꿔봄
// 합병 정렬 알고리즘은 2022.5.31(화) ~ 2022.6.1(수)에 작성한 것
public class Main10989_Buffered {
    public static void main(String[] args) throws IOException {
        // 데이터 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정렬 대상 수의 개수 = 1 ~ 10,000,000

        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 = 오름차순 정렬
        int[] sortedArr = mergeSort(inputArr, n);

        // 출력 = 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력
        // 방법1) StringBuilder 사용 = 23h59 메모리 초과
        StringBuilder sb = new StringBuilder();

        for (int i : sortedArr) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);

        // 방법2) BufferedWriter 사용 = 23h59 시간 초과
        /*
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : sortedArr) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
         */
    }

    public static int[] mergeSort(int[] arr, int n) {
        if (n > 1) {
            int mid = n / 2;

            // 왼쪽 부분정렬 만들기
            int[] leftArr = new int[mid];
            for (int i = 0; i < mid; i++) {
                leftArr[i] = arr[i];
            }

            leftArr = mergeSort(leftArr, mid);

            // 오른쪽 부분정렬 만들기
            int[] rightArr = new int[n - mid];
            for (int i = 0; i < n - mid; i++) {
                rightArr[i] = arr[mid + i];
            }

            rightArr = mergeSort(rightArr, n - mid);

            // 정렬된 두 부분배열의 합병
            arr = merge(leftArr, rightArr, mid, n);
        }

        return arr;
    }

    public static int[] merge(int[] leftArr, int[] rightArr, int mid, int n) {
        int[] mergedArr = new int[n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < mid && j < n - mid) {
            if (leftArr[i] <= rightArr[j]) {
                mergedArr[k] = leftArr[i];
                i++;
            } else {
                mergedArr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        // 왼쪽 부분배열에 남아있는 모든 원소를 mergedArr로 이동
        while (i < mid) {
            mergedArr[k] = leftArr[i];
            k++;
            i++;
        }

        // 오른쪽 부분배열에 남아있는 모든 원소를 mergedArr로 이동
        while (j < n - mid) {
            mergedArr[k] = rightArr[j];
            k++;
            j++;
        }

        return mergedArr;
    }
}
