class Solution {
    // 2022.12.30(금) 5h30
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) answer += i;
        }
        
        return answer;
    }
}