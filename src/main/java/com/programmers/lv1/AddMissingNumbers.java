package com.programmers.lv1;

import java.util.Arrays;

public class AddMissingNumbers {
    // 2023.2.7(화)
    public static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            for (int j = 0; j <= 9; j++) {
//                if (number ==)
            }
        }

        return answer;
    }
}
