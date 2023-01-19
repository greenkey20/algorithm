package lv1.q68644;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
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
}