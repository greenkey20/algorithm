package com.programmers.lv1;

import java.util.Arrays;

public class ReverseDigitsIntoArray {
    // 2023.1.3(화) 23h50 -> 2023.1.4(수) 1h5 제출 시 테스트3 실패(런타임 에러) = 왜인지 잘 모르겠음 -> 프로그래머스 런타임 에러 + 이 문제(https://velog.io/@stella317/프로그래머스-자연수-뒤집어-배열로-만들기) 간단 googling -> 문자열로 풀어보기
    public static int[] solutionDraft(long n) {
        int[] answer = {};
        /*
        int idx = 0;

        while (n > 0) {
            answer[idx] = (int) (n % 10);
            idx++;
            n = n / 10;
        }
        */
        if (n < 10) {
            answer[0] = (int) n;
            return answer;
        }

        long copyOfN = n;
        int count = 0;
        while (copyOfN > 0) {
            count++;
            copyOfN = copyOfN / 10;
        }
        answer = new int[count];

        /*
        if (count == 1) {
            answer[0] = (int) n;
            return answer;
        }
         */

        for (int i = 0; i < count; i++) {
            answer[i] = (int) (n % 10);
            n = n / 10;
        }

        return answer;
    }

    public static int[] solution(long n) {
        // 2023.1.4(수) 1h20 레퍼런스 참고 후 작성 -> 1h33 통과
        String nStr = String.valueOf(n);
        int[] answer = new int[nStr.length()];

        for (int i = nStr.length() - 1; i >= 0; i--) {
            char ch = nStr.charAt(i);
            answer[nStr.length() - i - 1] = Character.getNumericValue(ch);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }
}
