package com.programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonDigits {
    // 2023.2.11(토) 19h5 -> 19h30 v1 = 의도한대로 동작x
    public static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        List<Character> commonDigits = new ArrayList<>();

        // X의 숫자 하나하나를 Y의 숫자 하나하나와 비교 -> Y에 있으면 해당 숫자를 commonDigits list에 추가 + 해당 숫자를 Y에서 제거
        for (int i = 0; i < X.length(); i++) {
            char chX = X.charAt(i);

            for (int j = 0; j < Y.length(); j++) {
                char chY = Y.charAt(j);

                if (chX == chY) {
                    commonDigits.add(chX);
                    Y.replaceFirst(Character.toString(chY), "");
                }
            }
        }

        // commonDigits에 원소가 없다면 "-1" 반환
        if (commonDigits.isEmpty()) return "-1";

        // commonDigits의 원소가 모두 0이라면 "0" 반환
        int sum = 0;
        for (int i = 0; i < commonDigits.size(); i++) {
            int num = Character.getNumericValue(commonDigits.get(i));
            sum += num;
        }

        if (sum == 0) return "0";

        // commonDigits 원소들 중 0이 아닌 숫자가 있다면
        // commonDigits 원소들을 오름차순으로 정렬
        Collections.sort(commonDigits);
        System.out.println(commonDigits); // todo

        for (int i = commonDigits.size() - 1; i >= 0; i--) {
            sb.append(commonDigits.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("100", "2345"));
        System.out.println(solution("100", "203045"));
        System.out.println(solution("100", "123450"));
        System.out.println(solution("12321", "42531"));
        System.out.println(solution("5525", "1255"));
    }
}
