package com.programmers.lv1;

import java.util.*;

// 2023.4.6(목) 22h25 ~ 22h40 v1 첫번째 사진의 nostalgiaScore만 계산됨
public class NostalgiaScores {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];

        Map<String, Integer> nameAndScore = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameAndScore.put(name[i], yearning[i]);
        }
        System.out.println("name and score = " + nameAndScore); // todo

        Set set = nameAndScore.entrySet();
        Iterator it = set.iterator();

        for (int i = 0; i < photos.length; i++) {
            List<String> photoList = Arrays.asList(photos[i]);
            int nostalgiaScore = 0;

            while (it.hasNext()) {
                Map.Entry e = (Map.Entry) it.next();
                String nm = (String) e.getKey();

                if (photoList.contains(nm)) {
                    nostalgiaScore += (Integer) e.getValue();
                }
            }

            answer[i] = nostalgiaScore;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
