package com.programmers.lv1;

import java.util.*;

public class AdditionOfCombinationOfTwo {
    // 2023.1.18(수) 2h40 -> 3h version1 완성해서 입/출력 예시대로 동작하는 듯
    public static int[] solution(int[] numbers) {
        Set<Integer> answerSet = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                answerSet.add(sum);
            }
        }

        /*
        Object[] answerSetToArray = answerSet.toArray();
        int[] answer = new int[answerSetToArray.length];

        for (int i = 0; i < answerSetToArray.length; i++) {
            answer[i] = (int) answerSetToArray[i];
        }

        return answer;
         */

        // 다른 사람들의 풀이로부터 배운 Stream 활용
        return answerSet.stream().sorted().mapToInt(num -> num).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }
}
