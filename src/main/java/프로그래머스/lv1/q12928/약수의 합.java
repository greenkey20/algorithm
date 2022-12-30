package 프로그래머스.lv1.q12928;

class Solution {
    // 2022.12.30(금) 5h30 -> 5h35 다른 사람의 풀이 참고해서 더 효율적인 반복문으로 풀어보기
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer+= i;
                if (i != Math.sqrt(n)) {
                    answer = answer + n / i;
                }
            }
        }
        
        return answer;
    }
}