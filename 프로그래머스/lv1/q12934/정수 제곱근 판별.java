package lv1.q12934;

class Solution {
    // 2023.1.5(목) 6h55
    public long solution(long n) {
        /*
        long answer = -1;
        
        for (int i = Math.sqrt(n); i >= 2; i--) {
            if (n == i * i) return (i + 1) * (i + 1);
        }
        
        return answer;
        */
        if (n == (long) Math.sqrt(n) * (long) Math.sqrt(n)) return (long) Math.pow(Math.sqrt(n) + 1, 2);
        else return -1;        
    }
}