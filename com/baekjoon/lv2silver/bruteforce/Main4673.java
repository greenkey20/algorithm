package com.baekjoon.lv2silver.bruteforce;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

// 2022.12.13(화) 0h30 -> 0h55 일단 v1 = 1~1만 모든 숫자가 출력됨
// 종이에 d(1), d(2), d(3), .. 써가며 self number 개념 이해
public class Main4673 {
    static ArrayList<Integer> listOfNums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력 = 없음
        // 단, 문제에서 10,000보다 작거나 같은 self numbers를 구하라는 조건 주어짐
        for (int i = 1; i <= 10000; i++) {
            listOfNums.add(i);
        }

        // 문제 해결 로직

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < listOfNums.size(); i++) {
            bw.write(listOfNums.get(i) + "\n");
        }

        bw.close();
        bw.close();
    }

    public static void getListOfSelfNums(ArrayList<Integer> listOfNums) {
        for (int i = 0; i < listOfNums.size(); i++) {
            int n = listOfNums.get(i);
            int derivativeOfN = n;

            while (n / 10 > 0) {
                derivativeOfN += n / 10;
            }

            listOfNums.remove(derivativeOfN);
        }
    }
}
