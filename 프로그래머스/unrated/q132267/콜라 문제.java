class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        int currentNumOfEmptyBottles = 0;

        boolean flag = true;
        while (flag) {
            currentNumOfEmptyBottles = n / a * b + n - (n / a) * a;
            answer = answer + n / a * b;
            n = currentNumOfEmptyBottles;

            if (currentNumOfEmptyBottles < a) flag = false;
        }

        return answer;
    }
}