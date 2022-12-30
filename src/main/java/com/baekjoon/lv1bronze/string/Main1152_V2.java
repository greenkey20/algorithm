package com.baekjoon.lv1bronze.string;

import java.io.*;

// 2022.12.5(월) 6h45 올해4월에 풀었던 것 리뷰 + 구글링 후, 성능 개선 리팩토링 및 새로운 알고리즘 시도
public class Main1152_V2 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        // 구현

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(countNumOfWords(words)));

        bw.flush();
        bw.close();

        br.close();
    }

    public static int countNumOfWords(String words) {
        // v1 = StringTokenizer 클래스 사용
        /*
        StringTokenizer st = new StringTokenizer(words, " "); // 공백을 기준으로 나뉘어 토큰에 저장 -> 그래서 문자열 처음/마지막 공백에 대해 별다른 예외 처리를 안 해줘도 됨 -> 7h 나의 질문 = 왜? 이 로직('그래서') 이해 안 됨
        int cnt = st.countTokens();
         */

        // 7h10 v2 = 공백 수 세기 -> 7h20 제출 시 '틀렸습니다'
        String wordsTrimmed = words.trim(); // input 문자열 왼/오른쪽 끝에 있는 공백을 제거한 문자열

//        if (Character.toString(wordsTrimmed.charAt(0)).equals("")) return 0;

        int cnt = 1;
        for (int i = 1; i < wordsTrimmed.length(); i++) {
            char current = wordsTrimmed.charAt(i);
            char previous = wordsTrimmed.charAt(i - 1);
            if (previous != ' ' && current == ' ') cnt++;
        }

        return cnt;
    }
}
