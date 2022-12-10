package com.baekjoon.lv3gold.recursion;

// 2022.12.10(토) 20h45

import java.io.*;
import java.nio.Buffer;

/**
 * N-Queen 문제 = N * N 크기 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓기 -> N(1~14 자연수)이 주어졌을 때 N개의 queens를 서로 공격할 수 없게 놓는 방법/경우의 수 구하기
 * 백준 분류 알고리즘 = brute force, backtracking(해결책에 대한 후보를 구축해 나아가다, 가능성이 없다고 판단되는 즉시 후보를 포기/backtrack해 정답을 찾아감)
 *
 * 처음에는 문제 자체 이해가 안 되어서 googling -> https://st-lab.tistory.com/118 쭉 읽어봄
 * queen = 상/하/좌/우 및 대각선으로 거리 제한 없이 한 방향으로 이동 가능
 *
 * ideation = 0번째 열에서 0 ~ N-1번째 행별로 다음 열들에서 queen이 위치할 수 있는 곳(행)들 찾음 -> 그 결과에 따라 1번째 열에서 queen이 위치할 수 있는 행별로 다음 열들에서 queen이 위치할 수 있는 곳(행)들 찾음..
 * -> 그런데 이걸 어떻게 구현해야 할까?
 * -> 위 참고 문헌 보면서 코드로 써봄
 */
public class Main9663 {
    // 클래스 변수 선언 -> static 메서드 안에서 사용하려면 static 변수로 만들어야 함
    public static int N;
    public static int count = 0;
    public static int[] arr;


    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // 문제 해결 로직
        nQueen(0);

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));

        bw.flush();
        bw.close();
        br.close();
    }

    // 재귀 호출
    public static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) { // 각 column/열을 하나씩 순회하면서
            arr[depth] = 1; // 21h35 사실 arr[] 배열의 의미/용도가 뭔지 모르겠다..
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isPossible(int column) {
        for (int i = 0; i < column; i++) {

        }

        return true;
    }
}
