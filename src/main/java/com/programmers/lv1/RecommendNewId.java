package com.programmers.lv1;

public class RecommendNewId {
    // 2023.1.22(일) 15h20 -> 15h50 입/출력 예시에 version1 돌려봤는데 2단계에서(부터) 이상한 결과 나옴 -> 16h 2단계까지만 고침
    public static String solution(String new_id) {
        // 1단계
        String step1 = new_id.toLowerCase();
        System.out.println("1단계 = " + step1);

        // 2단계
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < new_id.length(); i++) {
            char ch = step1.charAt(i);

            if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                sb1.append(ch);
            } else {
                sb1.append("");
            }
        }

        String step2 = sb1.toString();
        System.out.println("2단계 = " + step2);

        // 3단계
        StringBuilder sb2 = new StringBuilder();

        if (step2.charAt(0) != '.') {
            sb2.append(step2.charAt(0));
        }

        for (int i = 1; i < step2.length(); i++) {
            if (step2.charAt(i - 1) == '.' && step2.charAt(i) == '.') {
                sb2.append(".");
            } else {
                sb2.append(step2.charAt(i));
            }
        }

        String step3 = sb2.toString();
        System.out.println("3단계 = " + step3);

        // 4단계
        StringBuilder sb3 = new StringBuilder();

        for (int i = 0; i < step3.length(); i++) {
            char ch = step3.charAt(i);

            if (!(ch == '.' && (i == 0 || i == step1.length() - 1))) {
                sb3.append(ch);
            }
        }

        String step4 = sb3.toString();
        System.out.println("4단계 = " + step4);

        // 5단계
        StringBuilder sb4 = new StringBuilder();

        if (step4.length() == 0) {
            sb4.append("a");
        } else {
            sb4.append(step4);
        }

        String step5 = sb4.toString();
        System.out.println("5단계 = " + step5);

        // 6단계
        if (step5.length() >= 16) {
            step5.substring(0, 14);
        }

        System.out.println("6단계 = " + step5);

        // 7단계
        StringBuilder sb5 = new StringBuilder(step5);
        if (step5.length() <= 2) {
            while (sb5.length() != 3) {
                sb5.append(step5.charAt(step5.length() - 1));
            }
        }

        String answer = sb5.toString();
        System.out.println("7단계 = " + answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm")); // "bat.y.abcdefghi"
        System.out.println(solution("z-+.^.")); // "z--"
        System.out.println(solution("=.=")); // "aaa"
        System.out.println(solution("123_.def")); // "123_.def"
        System.out.println(solution("abcdefghijklmn.p")); // "abcdefghijklmn"
    }
}
