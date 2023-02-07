package com.programmers.lv1;

import java.util.List;

public class NumbersWrittenInWords {
    // 2023.2.8(수) 2h 풀이 시작 -> 2h20 제출 '맞았습니다'
    public static int solution(String s) {
        int answer = 0; // 1 ~ 20억 범위의 정수
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

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
}
