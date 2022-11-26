class Solution {
    // 2022.11.26(토) 23h50
    public long solution(int a, int b) {
        long answer = 0;        
        
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }
        
        return answer;
    }
}