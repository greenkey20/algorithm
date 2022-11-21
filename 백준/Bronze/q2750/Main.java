package 백준.Bronze.q2750;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 데이터 입력받기
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 선택 정렬 알고리즘 구현
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    // arr[i]와 arr[j]의 자리 바꾸기
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}