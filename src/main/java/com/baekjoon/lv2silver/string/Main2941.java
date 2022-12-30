package com.baekjoon.lv2silver.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// 2022.12.14(수) 13h50 v1 제대로 동작 안 함, 테스트케이스들 종이에 써가며 더 정교하게 짜보자.. -> 2022.12.15(목) 2h25 다시 시도했으나, 잘 모르겠음 -> 2h55 검색해보기로 함 + v2 '틀렸습니다'(반례는 c=c=와 같이 크로아티아 알파벳 1개가 2번 이상 나올 때)
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

//        StringBuilder sb = new StringBuilder(word);

        // 2022.12.17(토) 6h50 v3
        for (int i = 0; i < croatianAlphabets.size(); i++) {
            String str = croatianAlphabets.get(i);

            if (word.indexOf(str) != -1) {
//                int begin = word.indexOf(str);
                word = word.replace(str, "*");
            }

            System.out.println("str = " + str + ", word = " + word);
        }

        return word.length();
    }
}

/* 회고
1. String의 성질/특성에 대해 제대로 공부해두자
2. String.replace()한 결과를 변수에 담지 않아 '왜 안 되지?' 한 순간이 2번 이상된다..

ideation
int result = 0;

StringBuilder sb = new StringBuilder();

for (int i = 0; i < word.length(); i++) {
    char ch = word.charAt(i);
    if (!(ch == 'c' || ch == 'd' || ch == 'l' || ch == 'n' || ch == 's' || ch == 'z')) {
        result++;


        sb.append(word.charAt(i));

        if (sb.length() > 1) {
            for (String croatianAlphabet : croatianAlphabets) {
                if (sb.indexOf(croatianAlphabet) > 0) {
                    result++;
                    sb = new StringBuilder();
                }
            }
        }
    } else {
        result++;
    }
}

result += sb.length();

references
https://st-lab.tistory.com/68
https://hellodoor.tistory.com/86
 */
