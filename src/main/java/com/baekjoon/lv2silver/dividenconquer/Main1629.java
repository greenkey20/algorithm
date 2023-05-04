package com.baekjoon.lv2silver.dividenconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2023.5.4(목) 18h15 ~ 18h30 Math 클래스 활용해서 제출해보기 = 틀렸습니다, Math.pow() 결과도 long 자료형 범위를 넘어갈 수 있기에 이렇게 풀면 틀린다
public class Main1629 {
    public static int base;
    public static int exponent;
    public static int divisor;

    // main()
    public static void main(String[] args) throws IOException {
        baekjoonInput();

        long result = baseRaisedToPowerOfExponent(base, exponent, divisor);

        presentSolution(result);
    }

    // 데이터 입력받기
    public static void baekjoonInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // e.g. 10 11 12 -> 4
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        base = Integer.parseInt(st.nextToken());
        exponent = Integer.parseInt(st.nextToken());
        divisor = Integer.parseInt(st.nextToken());
    }

    // 결과 출력
    public static void presentSolution(long result) {
        System.out.println(result);
    }

    // 문제 해결 로직
    public static long baseRaisedToPowerOfExponent(int base, int exponent, int divisor) {
        return (long) (Math.pow(base, exponent)) % divisor;
    }

}
