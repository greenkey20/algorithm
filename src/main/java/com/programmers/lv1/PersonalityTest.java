package com.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTest {
    // 2023.2.16(목) 18h20 -> 19h 맞았습니다
    public static String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            String indicators = survey[i];

            int score = 0;
            char indicator = ' ';

            if (choice < 4) {
                score = 4 - choice;
                indicator = indicators.charAt(0);
            } else if (choice > 4) {
                score = choice - 4;
                indicator = indicators.charAt(1);
            }

            if (score > 0) {
                int oldScore = map.get(indicator);
                map.put(indicator, oldScore + score);
            }
        }
        // 현재까지 각 지표별 점수 map에 합산됨
        System.out.println(map); // todo

        int RScore = map.get('R');
        int TScore = map.get('T');
        int CScore = map.get('C');
        int FScore = map.get('F');
        int JScore = map.get('J');
        int MScore = map.get('M');
        int AScore = map.get('A');
        int NScore = map.get('N');

        if (RScore >= TScore) {
            sb.append('R');
        } else {
            sb.append('T');
        }

        if (CScore >= FScore) {
            sb.append('C');
        } else {
            sb.append('F');
        }

        if (JScore >= MScore) {
            sb.append('J');
        } else {
            sb.append('M');
        }

        if (AScore >= NScore) {
            sb.append('A');
        } else {
            sb.append('N');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}
