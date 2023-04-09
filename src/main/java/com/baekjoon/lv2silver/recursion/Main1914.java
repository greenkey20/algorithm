package com.baekjoon.lv2silver.recursion;

import java.io.*;
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
2023.4.9(일) 23h50 내가 조금 더 이해하는 대로 다시 작성해 봄 -> 메모리 사용은 -39.3%, 시간은 -90.6% = 어떻게 이렇게 되었을까?
references = https://hyunjiishailey.tistory.com/42
 */
public class Main1914 {
    static ArrayList<int[]> steps;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 문제 해결 로직
        StringBuilder sbResult = new StringBuilder();

        // 이동 횟수는 공식/점화식 이용해서 출력
        // n이 100일 때 long의 범위를 넘어감
        BigInteger count = new BigInteger("2");
        sbResult.append(count.pow(n).subtract(new BigInteger("1")));

        // n이 20 이하인 입력에 대해서는 두 번째 줄부터 수행 과정을 출력
        steps = new ArrayList<>();
        if (n <= 20) {
            sbResult.append("\n");
            hanoi(n, 1, 2, 3);

            for (int i = 0; i < steps.size(); i++) {
                int[] step = steps.get(i);
                sbResult.append(step[0] + " " + step[1] + "\n");
            }
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sbResult.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            steps.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, to, via); // 나의 궁금증 = 1개 원판만 1회에 옮길 수 있는데, 왜/어떻게 n-1개를 옮기는 것으로 생각(해야)하지..?
            steps.add(new int[]{from, to});

            hanoi(n - 1, via, from, to); // 나의 궁금증 = 3번 자리로 가는 move는 기록을 안 하는 게 맞나?
        }
    }
}
