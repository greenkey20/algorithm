package com.baekjoon.lv1bronze.string;

// 2022.12.5(월) 6h10

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 주어짐 -> 주어진 글자의 아스키 코드값을 출력
 */
public class Main11654 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char ch = br.readLine().charAt(0);

        // 구현

        // 출력
        // 방법1)
        System.out.println(getAsciiCode(ch)); // 0 입력 -> 48 출력
        // 방법2)
        /*
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(getAsciiCode(ch)); // 0 입력 -> 0 출력 -> 왜/어떻게 이렇게 되는지 알아봐야 함

        bw.flush();
        bw.close();
         */

        br.close();
    }

    // 구현
    public static int getAsciiCode(char ch) {
//        return ch; // v1 = 숫자 9 입력 시, 9 출력 != 의도하는 바
//        int asciiCode = Character.getNumericValue(ch); // v2 = 숫자 9 입력 시, 9 출력 != 의도하는 바
        int asciiCode = ch;
//        if ('0' <= ch || ch <= '9') asciiCode = ch + 48; // ch를 int형 변수에 저장하면 ascii code 값으로 저장됨 -> 이 line 필요 없음

        return asciiCode;
    }

    /* 회고
    1. Java char의 속성은 재미있다.. 그런데 다룰 때마다 저장 값 등이 조금 헷갈린다. 제대로 알아두자..
    2. 오늘 문제에서도 BufferedWriter는 의도/예상하지 않은 값을 출력한다. 왜 그런 것일까?
     */
}
