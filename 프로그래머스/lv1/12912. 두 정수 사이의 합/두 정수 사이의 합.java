class Solution {
    // 2022.11.26(토) 23h50
    public long solution(int a, int b) {
        long answer = 0;        
        long smaller = a;
        long bigger = b;
        
        if (a == b) answer = a;
        else {
            if (a > b) {
                smaller = b;
                bigger = a;
            }
            
            for (long i = smaller; i <= bigger; i++) {
                answer += i;
            }
        }
        
        return answer;
    }
}