package com.baekjoon.lv2silver.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 2022.12.23(금) 0h35 -> v1 1h30 틀렸습니다
public class Main1316 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 문제 풀이 로직

        // 출력
        System.out.println(numOfGroupWords(words));

    }

    public static int numOfGroupWords(String[] words) {
        int result = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1) { // 2022.12.23(금) 21h35 입/출력예시2로 돌려보니 이 경우 처리 안 했음을 깨닫게 됨 -> 21h40 맞았습니다
                result++;
                continue;
            }

            Set<Character> alphabets = new HashSet<>();

            for (int j = 0; j < words[i].length() - 1; j++) {
                char thisCh = words[i].charAt(j);
                char nextCh = words[i].charAt(j + 1);

                alphabets.add(thisCh);

                if (thisCh != nextCh) {
                    if (!alphabets.contains(nextCh)) {
                        alphabets.add(nextCh);
                    } else {
                        break;
                    }
                }

//                System.out.println(alphabets);
                if (j == words[i].length() - 2) result++;
            }
        }

        return result;
    }
}
