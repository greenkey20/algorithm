package com.programmers.lv1;

public class CaesarCipher {
    // 2022.12.29(목) 1h -> 2022.12.30(금) 12h55 이어서 작성, 40분 정도 고민하다가 숫자 패턴 어떻게 만들어야 할지 모르겠어서 코플릿 데일리코딩 19번 풀이 참고
    public static String solution(String s, int n) {
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

    public static void main(String[] args) {
        System.out.println(solution("a B z", 4));
        System.out.println(solution("z", 1));
    }
}
