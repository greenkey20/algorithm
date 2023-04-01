package com.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

// 2023.4.1(토) 21h50 ~ 22h5 v1 맞았습니다
// 문제 읽고, 알파벳들을 어떻게 저장해서 활용할까 생각하며, Java정석 ArrayList의 메서드들 보다가
// 특정 문자를 remove할 수도 있고, 특정 문자의 index도 찾을 수 있는 것을 보고, list로 풀기로 함 -> 한 줄 한 줄 생각대로 구현해봄
public class SkipCiphertext {
    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        String sourceStr = "abcdefghijklmnopqrstuvwxyz";
        List<Character> sourceList = new ArrayList<>();

        for (int i = 0; i < sourceStr.length(); i++) {
            sourceList.add(sourceStr.charAt(i));
        }
        //System.out.println(sourceList); // todo

        for (int i = 0; i < skip.length(); i++) {
            //sourceList.remove(skip.charAt(i));
            sourceList.remove(Character.valueOf(skip.charAt(i)));
        }
        //System.out.println(sourceList); // todo

        for (int i = 0; i < s.length(); i++) {
            int cipherIndex = sourceList.indexOf(s.charAt(i));
            Character decoded = sourceList.get((cipherIndex + index) % sourceList.size());

            sb.append(decoded);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5)); // happy
    }
}
