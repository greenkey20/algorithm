package com.baekjoon.lv2silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

// 2022.12.17(토) 문제 읽고 와서 7h45 ~ 7h50 초안 작성 -> 2022.12.18(일) 0h30 이어서 작성 -> 1h50 1시간 이상 고민했으나 일단 아직 못 품
public class Main2960 {
    static ArrayList<Integer> primeNumbers = new ArrayList<>();
    static LinkedHashSet<Integer> sieveSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // 2 ~ N까지 모든 정수 중에서
        int K = Integer.parseInt(inputs[1]); // 에라토스테네스의 체에 따라 K번째로 지우는 수를 return

        // 문제 해결 로직
        getPrimeNumbers(N);
        kThSieve(N, K);
        Integer[] sieveArr = sieveSet.toArray(new Integer[0]);

        // 출력
        System.out.println(sieveArr[sieveArr.length - 1]);
    }

    public static void kThSieve(int N, int K) {
        for (int i = 0; i < primeNumbers.size(); i++) {
            int thisPrimeNum = primeNumbers.get(i);
            int divisor = N / thisPrimeNum;

            for (int j = 1; j <= N; j++) {
                sieveSet.add(j * thisPrimeNum);
                if (sieveSet.size() == K) {
                    return;
                }
            }
        }
    }

    // 2 ~ N 사이의 모든 소수를 먼저 구함
    public static void getPrimeNumbers(int N) {
        boolean isPrimeNumber = true;
        primeNumbers.add(2);

        for (int i = 3; i <= N; i++) {
            if (i % 2 == 0) continue;

            for (int j = 3; j <= Math.sqrt(N); j += 2) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) primeNumbers.add(i);
        }

        System.out.println(primeNumbers); // todo
    }
}

/* ideation
ArrayList<Integer> allNumbers = new ArrayList<>();

for (int i = 2; i <= N; i++) {
    allNumbers.add(i);
}

for (int i = 0; i < allNumbers.size(); i++) {
    int thisNum = allNumbers.get(i);

    for (int j = 0; i < primeNumbers.size(); i++) {
        int primeNumber = primeNumbers.get(i);
        if (N % primeNumber == 0) {

        }
    }

}
 */
