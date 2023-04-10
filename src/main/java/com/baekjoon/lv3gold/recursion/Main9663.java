package com.baekjoon.lv3gold.recursion;

// 2022.12.10(토) 20h45

import java.io.*;
import java.util.Arrays;

/**
 * N-Queen 문제 = N * N 크기 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓기 -> N(1~14 자연수)이 주어졌을 때 N개의 queens를 서로 공격할 수 없게 놓는 방법/경우의 수 구하기
 * 백준 분류 알고리즘 = brute force, backtracking(해결책에 대한 후보를 구축해 나아가다, 가능성이 없다고 판단되는 즉시 후보를 포기/backtrack해 정답을 찾아감)
 * <p>
 * 처음에는 문제 자체 이해가 안 되어서 googling -> https://st-lab.tistory.com/118 쭉 읽어봄
 * queen = 상/하/좌/우 및 대각선으로 거리 제한 없이 한 방향으로 이동 가능
 * <p>
 * ideation = 0번째 열에서 0 ~ N-1번째 행별로 다음 열들에서 queen이 위치할 수 있는 곳(행)들 찾음 -> 그 결과에 따라 1번째 열에서 queen이 위치할 수 있는 행별로 다음 열들에서 queen이 위치할 수 있는 곳(행)들 찾음..
 * -> 그런데 이걸 어떻게 구현해야 할까?
 * -> 위 참고 문헌 보면서 코드로 써봄
 *
 * 2023.4.10(월) 추가 reference = https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
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
        bw.write("count = " + Integer.toString(count)); // todo

        bw.flush();
        bw.close();
        br.close();
    }

    // 재귀 호출
    public static void nQueen(int depth) {
        System.out.println("===== nQueen 함수 (재귀)호출됨 =====");
        if (depth == N) {
            count++;
            System.out.println("count 쌓인다!"); // todo
            System.out.println("arr[] 배열 = " + Arrays.toString(arr)); // todo
            return;
        }

        for (int i = 0; i < N; i++) { // 각 column/열을 하나씩 순회하면서
            arr[depth] = i; // 21h35 사실 arr[] 배열의 의미/용도가 뭔지 모르겠다.. -> 2023.4.10(월) 22h35 위 레퍼런스 블로그 읽고 이해했음 + depth컬럼의 i번째 행에 queen을 놓는다
//            System.out.println("depth = " + depth + ", i = " + i); // todo
            System.out.println(depth + "컬럼의 " + i + "번째 행에 queen을 놓는다"); // todo
            System.out.println("arr[] 배열 = " + Arrays.toString(arr)); // todo
            if (isPossible(depth)) {
                System.out.println("isPossible(" + depth + ") = true라서 여기 옴"); // todo
                nQueen(depth + 1);
                System.out.println("isPossible(" + (depth + 1) + ")를 빠져나감"); // todo
            }
        }
    }

    // 2023.4.10(월) 22h40
    // 해당 열에서 i번째 행에 queen을 놓을 수 있는지 없는지 확인하는 함수
    public static boolean isPossible(int column) {
        System.out.println("여긴 isPossible() 함수"); // todo

        for (int i = 0; i < column; i++) {
//            System.out.println("column = " + column + ", i = " + i); // todo
            System.out.println(column + "컬럼에서 " + i + "번째 행에 queen을 놓을 수 있나?");

            if (arr[i] == arr[column]) {
                System.out.println("같은 행에 존재함 >.<"); // todo
                return false;
            } else if (Math.abs(column - i) == Math.abs(arr[column] - arr[i])) { // 대각선 == 행의 index들 차와 열의 index들 차가 같은 위치들 -> reference 보고 원리는 이해한 것 같아서 작성했는데, 왜 이런 식(expression)으로 쓰는지는 이해 아직 안 됨 2023.4.11(화) 0h20
                System.out.println("대각선에 존재함 >.<"); // todo
                return false;
            }
        }

        System.out.println("여기에는 queen을 놓을 수 있다!"); // todo
        return true;
    }
}
