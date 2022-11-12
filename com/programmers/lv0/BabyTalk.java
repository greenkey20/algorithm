package com.programmers.lv0;

public class BabyTalk {
    // 2022.11.12(토) 23h50
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("aya") || babbling[i].contains("ye") || babbling[i].contains("woo") || babbling[i].contains("ma"))
                answer++;
        }
        return answer;
    }
}
