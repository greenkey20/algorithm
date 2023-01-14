package lv1.q12948;

class Solution {
    // 2023.1.14(토) 23h55
    public String solution(String phone_number) {
        //String answer = "";
        //String last4Digits = phone_number.substring(phone_number.length() - 4, phone_number.length());
        StringBuilder sb = new StringBuilder();
        
    for (int i = 0; i < phone_number.length(); i++) {
        if (i < phone_number.length() - 4) {
            sb.append("*");
        } else {
            sb.append(phone_number.charAt(i));
        }
    }       
        
        return sb.toString();
    }
}