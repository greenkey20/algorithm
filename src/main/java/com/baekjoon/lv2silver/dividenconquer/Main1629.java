package com.baekjoon.lv2silver.dividenconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2023.5.4(목) 18h15 ~ 18h30 v1 Math 클래스 활용해서 제출해보기 = 틀렸습니다, Math.pow() 결과도 long 자료형 범위를 넘어갈 수 있기에 이렇게 풀면 틀린다
// ~ 18h50 v2 = 시간 초과 = 왜일까? 어느 부분을 개선해야 할까?
/* A, B, C는 모두 2,147,483,647(Java int 자료형의 최대값) 이하의 자연수 -> 이런 A, B를 거듭제곱하면 long 자료형 범위도 넘어감 + 시간 초과도 될 거라고 함ㄴ
reference = https://st-lab.tistory.com/237
 */
public class Main1629 {
    public static int a;
    public static int b;
    public static int c;

    // main()
    public static void main(String[] args) throws IOException {
        baekjoonInput();

        long result = baseRaisedToPowerOfExponent(a, b, c);

        presentSolution(result);
    }

    // 데이터 입력받기
    public static void baekjoonInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // e.g. 10 11 12 -> 4
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }

    // 결과 출력
    public static void presentSolution(long result) {
        System.out.println(result % c);
    }

    // 문제 해결 로직
    public static long baseRaisedToPowerOfExponent(int base, int exponent, int divisor) {
        // v2
        if (exponent == 1) {
            return base;
        }

        if (exponent % 2 == 0) {
            return baseRaisedToPowerOfExponent(base, exponent / 2, divisor) * baseRaisedToPowerOfExponent(base, exponent / 2, divisor);
        }

        return baseRaisedToPowerOfExponent(base, exponent / 2, divisor) * baseRaisedToPowerOfExponent(base, exponent / 2, divisor) * baseRaisedToPowerOfExponent(base, 1, divisor);

        // v1
//        return (long) (Math.pow(base, exponent)) % divisor;
    }

}
