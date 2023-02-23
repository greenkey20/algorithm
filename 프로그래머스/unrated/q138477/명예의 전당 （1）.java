import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int numOfDays = score.length;
        int[] answer = new int[numOfDays];

        for (int i = 1; i <= numOfDays; i++) {
            int[] scores = new int[i];

            for (int j = 0; j < i; j++) {
                scores[j] = score[j];
            }

            Arrays.sort(scores);
            // System.out.println(i + "번째 날의 전체 점수 오름차순 = " + Arrays.toString(scores)); // todo

            if (i <= k) {
                answer[i - 1] = scores[0];
            } else {
                answer[i - 1] = scores[i - k];
            }
        }
        
        return answer;
    }
}