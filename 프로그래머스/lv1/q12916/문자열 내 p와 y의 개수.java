package 프로그래머스.lv1.q12916;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int cntP = 0;
        int cntY = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') cntP++;
            if (s.charAt(i) == 'y') cntY++;
        }

        return cntP == cntY;
    }
}