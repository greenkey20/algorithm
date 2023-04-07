package com.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 2023.4.7(금) 19h25 ~ 19h45 v1 68.0 = 5개(총 16개) 테스트케이스 시간 초과로 실패
public class RaceOfRunners {
    public String[] solution(String[] players, String[] callings) {
        //String[] answer = new String[players.length];
        List<String> answer = new ArrayList<>();
        answer.addAll(Arrays.asList(players));

        for (int i = 0; i < callings.length; i++) {
            String calling = callings[i];
            int backIdx = answer.indexOf(calling);

            String frontPlayer = answer.get(backIdx - 1);

            answer.set(backIdx, frontPlayer);
            answer.set(backIdx - 1, calling);

            //System.out.println("이번에 불린 선수 = " + calling + ", 선수들 순서 = " + answer);
        }

        return answer.toArray(new String[players.length]);
    }

    public static void main(String[] args) {
        RaceOfRunners ob = new RaceOfRunners();
        System.out.println(Arrays.toString(ob.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"})));
    }
}
