package com.baekjoon.lv2silver.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2022.12.31(토) 22h55 -> 아래 버전(입/출력 예시는 맞는 것 같은데) 23h30 제출 시 틀렸는데, 왜 틀렸는지 잘 모르겠음
public class Main1181 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N = 정렬 대상 단어의 개수
        Set<String> inputs = new HashSet<>(N);

        for (int i = 0; i < N; i++) {
            inputs.add(br.readLine());
        }

        // 문제 해결 로직

        // 출력
        StringBuilder sb = new StringBuilder();

        for (String word : sortWords(inputs)) {
            sb.append(word).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    public static List<String> sortWords(Set<String> inputs) {
        TreeSet<String> lengthAndInputs = new TreeSet<>();
        Iterator<String> it1 = inputs.iterator();

        while (it1.hasNext()) {
            String input = it1.next();
            String lengthAndInput = input.length() + input;
            lengthAndInputs.add(lengthAndInput);
        }

        Iterator<String> it2 = lengthAndInputs.iterator();
        List<String> words = new ArrayList<>();

        while (it2.hasNext()) {
            String word = it2.next().substring(1);
            words.add(word);
        }

        return words;
    }
}
