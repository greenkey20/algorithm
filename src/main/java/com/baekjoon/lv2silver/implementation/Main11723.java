package com.baekjoon.lv2silver.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 2022.12.25(일) 23h20 -> 2022.12.26(월) 2h40 이어서 풀이 -> 2h55 제출 시 '메모리 초과' -> 'bit masking' 구글링/공부
public class Main11723 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        ArrayList<String[]> commands = new ArrayList<>(M);

        for (int i = 0; i < M; i++) {
            commands.add(br.readLine().split(" "));
        }

        // 문제 해결 로직
        doSetOperation(commands);

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
     *
     * @param commands 명령의 집합
     */
    public static void doSetOperation(ArrayList<String[]> commands) {
        // v1
//        Set<Integer> set = new HashSet<>();
        // v2 bit masking 응용 = 총 20개의 요소를 갖는 int형 배열 선언 및 초기화(default value 0)
        int[] set = new int[20];

        for (int i = 0; i < commands.size(); i++) {
            String operator = commands.get(i)[0];
            Integer operand = 0;
            if (!operator.equals("all") && !operator.equals("empty")) {
                operand = Integer.parseInt(commands.get(i)[1]) - 1;
            }

            switch (operator) {
                case "add":
//                    set.add(operand);
                    set[0 << operand] = 1; // 3h55 나의 질문 = 왜 0 << operand가 항상 0의 값을 갖지?
                    System.out.println(Arrays.toString(set));
                    break;
                case "remove":
//                    set.remove(operand);
                    set[0 << operand] = 0;
                    break;
                case "check":
                    /*
                    if (set.contains(operand)) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                     */
                    if (set[0 << operand] == 1) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "toggle":
                    /*
                    if (set.contains(operand)) {
                        set.remove(operand);
                    } else {
                        set.add(operand);
                    }
                     */
                    if (set[0 << operand] == 1) {
                        set[0 << operand] = 0;
                    } else {
                        set[0 << operand] = 1;
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
//                        set.add(j);
                        set[0 << operand] = 1;
                    }
                    break;
                case "empty":
//                    set.clear();
                    for (int j = 1; j <= 20; j++) {
//                        set.add(j);
                        set[0 << operand] = 0;
                    }
            }
        }

    }
}
