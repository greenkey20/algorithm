package com.baekjoon.lv2silver.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 2022.12.14(수) 13h50 v1 제대로 동작 안 함, 테스트케이스들 종이에 써가며 더 정교하게 짜보자.. -> 2022.12.15(목) 2h25 다시 시도했으나, 잘 모르겠음 -> 2h55 검색해보기로 함
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

        StringBuilder sb = new StringBuilder(word);

        for (int i = 0; i < croatianAlphabets.size(); i++) {
            String str = croatianAlphabets.get(i);

            if (sb.indexOf(str) != -1) {
                int begin = word.indexOf(str);
                sb.replace(begin, begin + str.length(), "*");
            }

            System.out.println("str = " + str + ", sb = " + sb);
        }

        return sb.length();
    }
}


/* ideation
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
