package com.baekjoon.lv2silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022.12.11(일) 22h45 -> 23h5 오늘은 다른 문제/자료로 bfs/dfs 공부하다 왔다가, 입력 양식 작성하면서 1시간 알고리즘 공부 마무리
public class Main1260 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // 정점의 개수, 1 ~ 1000
        int M = Integer.parseInt(inputs[1]); // 간선의 개수, 1 ~ 10000
        int V = Integer.parseInt(inputs[2]); // 탐색 시작할 정점의 번호

        int[][] edges = new int[M][2];

        for (int i = 0; i < M; i++) {
            String[] nodes = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(nodes[0]);
            edges[i][1] = Integer.parseInt(nodes[1]);
        }

        // 주어진 그래프를 인접행렬 형태로 나타내기
        int[][] adjMatrix = new int[N][N];

        for (int i = 0; i < M; i++) {

        }

        // 문제 해결 로직

        // 출력
    }
}
