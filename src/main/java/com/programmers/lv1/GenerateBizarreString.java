package com.programmers.lv1;

public class GenerateBizarreString {
    /* 2022.12.30(금) 5h50 -> 6h5 제출 시 테스트케이스 반 정도 통과 못함 -> 2022.12.31(토) 4h50 다시 풀어보기
    게시판 tip = 단어 사이 공백이 여러 개 + 문자의 시작과 끝에 공백 + 단어에 대문자가 섞여있는 경우 e.g. "  tRy hello  WORLD    "
     */
    public static String solution(String s) {
        s = s.toLowerCase();

//        String answer = "";
        StringBuilder answerSb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
//                answer += ch;
                answerSb.append(ch);

                if (s.charAt(i + 1) != ' ' && count != 0) {
                    count++;
                }

                continue;
            } else if (count % 2 == 0) {
//                answer += (char) (ch - 32);
                answerSb.append((char) (ch - 32));
            } else {
//                answer += ch;
                answerSb.append(ch);
            }

            count++;
        }

        if (count % 2 == 0 && s.charAt(s.length() - 1) != ' ') {
//            answer = answer + (char) (s.charAt(s.length() - 1) - 32);
            answerSb.append((char) (s.charAt(s.length() - 1) - 32));
        } else {
//            answer += s.charAt(s.length() - 1);
            answerSb.append(s.charAt(s.length() - 1));
        }

//        return answer;
        return answerSb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("  tRy hello  WORLD    "));
    }

}
