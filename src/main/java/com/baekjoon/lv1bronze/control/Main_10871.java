package com.baekjoon.lv1bronze.control;

import java.io.*;

// 2022.12.3(토) 10h25 -> 10h40 제출 시 number format 런타임 에러(이번주 초 q10869 풀이 때와 같은 오류) -> 10h50 통과 + 그런데 메모리 왜 이렇게 많이(296700KB) 쓰게 되지? ㅠㅠ
public class Main_10871 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // v2 = 런타임 오류 해결을 위한 수정/추가
        String[] strs1 = br.readLine().split(" ");
        int N = Integer.parseInt(strs1[0]); // 주어지는 수들의 총 개수
        int X = Integer.parseInt(strs1[1]); // 크기 비교 대상 -> v2 처음 작성 시 strs1[0]라고 잘못 적어서 제대로 동작 안 했음

        String[] strs2 = br.readLine().split(" ");

        int[] nums = new int[N];

        // 입력 2번째 줄에 주어진 수들을 하나씩 배열 nums에 담음
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(strs2[i]); // 10h35 테스트 시 이 라인 좌변을 nums[0]으로 써놔서 제대로 동작 안 했음
        }
//        System.out.println("X는 " + X + ", 수열은 " + Arrays.toString(nums)); // toString() 안 쓰면 [I@1134affc -> v2 = X는 10, 수열은 [1, 10, 4, 9, 2, 3, 8, 5, 7, 6]

        // 별도의 메서드에서 문제 요구사항/로직 처리

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(getSmallerNumbersThanX(nums, X)); // 1 4 2 3

        br.close();
        bw.flush();
        bw.close();
    }

    public static String getSmallerNumbersThanX(int[] nums, int X) {
        String result = "";

        for (int num : nums) {
            if (num < X) result = result + num + " ";
        }

//        System.out.println(result); // 1 4 2 3
        return result;
    }

    /* 회고
    1. 로직 메서드 분리하니까 가독성도 좋고, 추후 공부할 때 찾아보기도 좋을 것 같다!
    2. 작은 실수들 있었는데, 바로바로 로그 찍어보고 잘 했어 + 어려운 문제 아니니까 로그 출력된 내용으로 어디가 문제인지 파악하는 것도 어렵지 않았다
    e.g. 예상 결과보다 더 많은 숫자들이 출력되었다? -> 비교가 제대로 잘 안 이루어지고 있다? -> 배열 nums는 잘 만들어졌는데, 그럼 X 값을 확인해보자..
    3. 문제에서 주어진 입력 형식을 유심히 읽고 정확히 숙지해서 입/출력 관련 시간을 줄이자
    4. 문제 결과 출력 String 자료 맨 끝에 공백문자 " " 하나 들어가 있는데, 정답 처리됨
     */
}
