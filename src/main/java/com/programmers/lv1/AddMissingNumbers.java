package com.programmers.lv1;

import java.util.Arrays;

public class AddMissingNumbers {
    // 2023.2.7(화) 시작 -> 2023.2.8(수) 계속 풀이 -> 2023.2.10(금) 1h50 제출해서 '맞았습니다'
    public static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        int[] base = new int[10];

        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == i) {
                    base[i] = i;
                }
            }
        }

        for (int i = 0; i < base.length; i++) {
            if (base[i] == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
