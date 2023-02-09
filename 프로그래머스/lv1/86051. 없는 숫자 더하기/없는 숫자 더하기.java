import java.util.*;

class Solution {
    public int solution(int[] numbers) {
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