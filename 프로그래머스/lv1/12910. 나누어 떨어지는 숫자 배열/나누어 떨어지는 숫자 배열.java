import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int check = arr[i];
            if (check % divisor == 0) answerList.add(check);
        }

        if (answerList.size() != 0) {
            int[] answer = new int[answerList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            Arrays.sort(answer);
            return answer;
        } else {
            return new int[]{-1};
        }
    }
}