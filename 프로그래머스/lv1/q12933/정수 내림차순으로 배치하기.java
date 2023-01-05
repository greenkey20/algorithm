package lv1.q12933;

import java.util.*;

class Solution {
    // 2023.1.4(수) 23h45
    public long solution(long n) {
        long answer = 0;
        
        String strN = String.valueOf(n);        
        int[] arrN = new int[strN.length()];
        
        for (int i = 0; i < strN.length(); i++) {
            arrN[i] = Character.getNumericValue(strN.charAt(i));
        }
        
        Arrays.sort(arrN);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = arrN.length - 1; i >= 0; i--) {
            sb.append(arrN[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}