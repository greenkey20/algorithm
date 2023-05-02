package com.baekjoon.lv1bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2023.5.3(수) 0h35 1629(분할정복 거듭제곱) 문제 풀다가, modulo 연산의 정리(knou 이산수학 p337 정리13.6)를 사용하는데, 그것을 증명하는 문제라고 하여 풀게 됨
public class Main10430 {
    public static int a;
    public static int b;
    public static int c;
    public static int[] results = new int[4];

    // main()
    public static void main(String[] args) throws IOException {
        baekjoonInput();
        // 또는 테스트 케이스들 입력으로 a, b, c 값 세팅
        //myTestInput();

        moduloOperations(a, b, c);
        presentSolution(results);
    }

    // data 입력받음
    public static void baekjoonInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }

    public static void myTestInput() {
        a = 5;
        b = 8;
        c = 4;
    }

    // 결과 출력
    public static void presentSolution(int[] results) { // 굳이 매개변수로 안 받아와도 되긴 한데..
        StringBuilder sb = new StringBuilder();
        for (int i : results) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    // 문제 해결 로직
    public static void moduloOperations(int a, int b, int c) { // 굳이 매개변수로 안 받아와도 되긴 한데, 메서드 시그너처만 봤을 때 메서드의 의미/내용/역할 이해에 더 좋은 것 같다고 생각
        results[0] = (a + b) % c;
        results[1] = ((a % c) + (b % c)) % c;
        results[2] = (a * b) % c;
        results[3] = ((a % c) * (b % c)) % c;
    }
}
