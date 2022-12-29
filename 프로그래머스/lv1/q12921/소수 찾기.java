package 프로그래머스.lv1.q12921;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            if (isPrimeNumber(i)) answer++;
        }
        
        return answer;
    }
    
    public static boolean isPrimeNumber(int i) {
        if (i == 1) return false; 
        
        if (i == 2 || i == 3) return true;
        
        if (i % 2 == 0) return false;
        
        for (int j = 3; j <= Math.sqrt(i); j += 2) {
            if (i % j == 0) return false;
        }
        
        return true;        
    }
}