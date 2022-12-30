package 프로그래머스.lv1.q12903;

class Solution {
    // 2022.11.17(목) 2h15
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        int mid = length / 2;
        
        if (length % 2 == 0) {
            answer = String.valueOf(s.charAt(mid - 1)) + String.valueOf(s.charAt(mid));
        } else {
            answer += s.charAt(mid);
        }
        
        return answer;
    }

    /* 회고
    1. 3항 연산자 활용해서 1줄로도 가능함
     */
}