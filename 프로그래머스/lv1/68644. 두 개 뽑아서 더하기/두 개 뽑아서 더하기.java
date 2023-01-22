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

        Object[] answerSetToArray = answerSet.toArray();
        int[] answer = new int[answerSetToArray.length];

        for (int i = 0; i < answerSetToArray.length; i++) {
            answer[i] = (int) answerSetToArray[i];
        }
        
        return answer;
    }
}