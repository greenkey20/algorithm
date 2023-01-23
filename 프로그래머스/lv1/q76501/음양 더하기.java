package lv1.q76501;

class Solution {
    // 2023.1.23(월) 22h
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            int absolute = absolutes[i];
            
            if (signs[i]) {
                answer += absolute;
            } else {
                answer += absolute * -1;
            }
        }
        
        
        return answer;
    }
}