package lv1.q12932;

class Solution {
    // 2023.1.3(화) 23h50
    public int[] solution(long n) {
        // 2023.1.4(수) 1h20 레퍼런스 참고 후 작성
        String nStr = String.valueOf(n);
        int[] answer = new int[nStr.length()];

        for (int i = nStr.length() - 1; i >= 0; i--) {
            char ch = nStr.charAt(i);
            answer[nStr.length() - i - 1] = Character.getNumericValue(ch);
        }

        return answer;
    }
}