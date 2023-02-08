import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        List<String> words = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        StringBuilder numberInString = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!Character.isDigit(ch)) {
                word.append(ch);

                if (words.contains(word.toString())) {
                    numberInString.append(words.indexOf(word.toString()));
                    word = new StringBuilder();
                }
            } else {
                numberInString.append(ch);
            }
        }

        for (int i = numberInString.toString().length(); i > 0; i--) {
            char ch = numberInString.toString().charAt(numberInString.length() - i);

            answer += Character.getNumericValue(ch) * (int) Math.pow(10, i - 1);
        }
        
        return answer;
    }
}