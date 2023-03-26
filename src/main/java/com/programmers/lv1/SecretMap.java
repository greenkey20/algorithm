package com.programmers.lv1;

import java.util.Arrays;

// 2023.3.27(월) 1h25 ~ 2h20 v1 입/출력 예제 통과 + 정확성 75.0(테스트 2개 통과 못함)
public class SecretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] arr1InBinaryNums = new String[n];
        String[] arr2InBinaryNums = new String[n];

        // 특정 자리수의 형식의 2진수로 출력하고 싶다 -> google '자바 2진수 자리수' = https://nsmchan.tistory.com/15
        for (int i = 0; i < n; i++) {
            arr1InBinaryNums[i] = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr1[i])));
            arr2InBinaryNums[i] = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(arr2[i])));
        }
//        System.out.println(Arrays.toString(arr1InBinaryNums)); // todo
//        System.out.println(Arrays.toString(arr2InBinaryNums)); // todo

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (arr1InBinaryNums[i].charAt(j) == '0' && arr2InBinaryNums[i].charAt(j) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }

//                System.out.println(sb); // todo
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
    }
}
