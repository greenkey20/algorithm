package com.programmers.lv1;

public class GenerateBizarreString {
    /* 2022.12.30(금) 5h50 -> 6h5 제출 시 테스트케이스 반 정도 통과 못함
    게시판 tip = 단어 사이 공백이 여러 개 + 문자의 시작과 끝에 공백 + 단어에 대문자가 섞여있는 경우 e.g. "  tRy hello  WORLD    "
     */
    public static String solution(String s) {
        s = s.toLowerCase();

        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ");
        String[] wordsTrimmed = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            wordsTrimmed[i] = words[i].trim();
        }

        for (int i = 0; i < wordsTrimmed.length; i++) {
            String word = wordsTrimmed[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (j % 2 == 0) answer.append((char) (ch - 32));
                else answer.append(ch);
            }

            answer.append(" ");
        }

        return answer.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
