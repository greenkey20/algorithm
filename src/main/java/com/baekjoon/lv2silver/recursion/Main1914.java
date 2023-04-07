package com.baekjoon.lv2silver.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

// 2022.12.9(금) 11h '하노이 탑' 백준 사이트 문제 및 입/출력 예시 읽어봤는데, 출력/내가 구해야 하는 것 이해가 잘 안 됨 -> google + youtube 참고해서 문제 및 기본 개념은 파악했으나, 11h40 아직 알고리즘/패턴 와닿지 않음
/*
e.g. 호출 1 = 목적지가 아닌곳(n-1, 즉 하나 적은 원반들을 목적지가 아닌 곳으로 옮기기)
프린트
임시 목적지로 옮기고
스타트 포인트에서 맨 아래에 남은 원반을 목적지로 옮기기
호출 2 = 임시 목적지에 있는걸 목적지로 옮기기
아아 장장 3시간만에 이해가 조금씩 갑니다

2022.12.10(토) 23h30 Eddie’s tips = stack<Integer> 3개 A~C 만들고, 1~N(입력받은 정수)과 같은 원소들을 가지고, stack 간 이동시켜보는 코드 써보기

2023.4.8(토) 1h15 https://devtitch.tistory.com/15 참고해서 v1 작성해 봄
 */
public class Main1914 {
    static ArrayList<int[]> steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        steps = new ArrayList<>();

        // n이 100일 때 long의 범위를 넘어감
        BigInteger count = new BigInteger("1");
        System.out.println(count.pow(n).subtract(new BigInteger("1")));

        // n이 20 이하인 입력에 대해서는 두 번째 줄부터 수행 과정을 출력
        if (n <= 20) {
            hanoi(n, 1, 3, 2);

            for (int i = 0; i < steps.size(); i++) {
                int[] step = steps.get(i);
                System.out.println(step[0] + " " + step[1]);
            }
        }
    }

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            steps.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, via, to);
            steps.add(new int[]{from, to});

            hanoi(n - 1, via, to, from);
        }
    }
}
