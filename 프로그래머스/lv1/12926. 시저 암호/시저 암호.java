class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";

        int asIs = 0;
        int toBe = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                answer.append(" ");
            } else if (ch < 97) {
                asIs = uppercaseLetters.indexOf(ch);
                toBe = (asIs + n) % 26;
                answer.append(uppercaseLetters.charAt(toBe));
            } else {
                asIs = lowercaseLetters.indexOf(ch);
                toBe = (asIs + n) % 26;
                answer.append(lowercaseLetters.charAt(toBe));
            }
        }

        return answer.toString();
    }
}