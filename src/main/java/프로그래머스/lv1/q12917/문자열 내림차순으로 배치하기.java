package 프로그래머스.lv1.q12917;

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars = new char[s.length()];
         
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);            
        }
        
        Arrays.sort(chars);
        answer = new StringBuilder(new String(chars)).reverse().toString();
        
        return answer;
    }
}