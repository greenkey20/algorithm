package com.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2023.3.31(금) 22h30 ~ 22h40 v1 맞았습니다
// 문제와 입출력 예시를 읽으며 어떻게 풀어야겠다, 어떤 자료구조 써야 할 것 같다 어렴풋이 생각 + 연습장에 간단히 메모 -> 한 줄 한 줄 바로 구현
public class ClosestSameAlphabet {
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> alphabets = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!alphabets.containsKey(ch)) {
                answer[i] = -1;
            } else {
                answer[i] = i - alphabets.get(ch);
            }

            alphabets.put(ch, i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana"))); // -1, -1, -1, 2, 2, 2
        System.out.println(Arrays.toString(solution("foobar"))); // -1, -1, 1, -1, -1, -1
    }
}
