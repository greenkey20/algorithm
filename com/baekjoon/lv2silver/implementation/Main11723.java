package com.baekjoon.lv2silver.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 2022.12.25(금) 23h20
public class Main11723 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        ArrayList<String[]> orders = new ArrayList<>(M);

        for (int i = 0; i < M; i++) {
            orders.add(br.readLine().split(" "));
        }

        // 문제 해결 로직

        // 출력


    }

    /**
     * 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.     *
     * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
     * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
     * check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
     * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
     * all: S를 {1, 2, ..., 20} 으로 바꾼다.
     * empty: S를 공집합으로 바꾼다.
     * @param orders
     */
    public static void doSetOperation(ArrayList<String[]> orders) {
        for (int i = 0; i < orders.size(); i++) {
            String[] order = orders.get(i);
        }

    }
}
