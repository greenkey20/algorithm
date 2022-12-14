package com.baekjoon.lv2silver.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 2022.12.14(수) 13h50 v1 제대로 동작 안 함, 테스트케이스들 종이에 써가며 더 정교하게 짜보자..
public class Main2941 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        // 문제 해결 로직

        // 출력
        System.out.println(countCroatianAlphabets(word));
    }

    public static int countCroatianAlphabets(String word) {
        List<String> croatianAlphabets = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        int result = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            if (croatianAlphabets.contains(sb)) {
                result++;
                sb = new StringBuilder();
            }
        }

        result += sb.length();

        return result;
    }
}
