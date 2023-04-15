import java.util.*;

class Solution {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            answer++;

            if (sum > budget) {
                answer--;
                break;
            }
        }

        return answer;
    }
}