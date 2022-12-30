package 프로그래머스.lv1.q12918;

class Solution {
    // 2022.12.29(목) 0h15
    public boolean solution(String s) {
        boolean answer = true;
        
        if (s.length() != 4 && s.length() != 6) return false;
        
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        
        return answer;
    }
}