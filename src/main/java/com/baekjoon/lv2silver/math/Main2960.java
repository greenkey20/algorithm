package com.baekjoon.lv2silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

// 2022.12.17(토) 문제 읽고 와서 7h45 ~ 7h50 초안 작성 -> 2022.12.18(일) 0h30 이어서 작성 -> 1h50 1시간 이상 고민했으나 일단 아직 못 품 -> 2022.12.19(월) 반복문 제어변수를 언제까지 증감할 건지 변수들 검토/수정한 뒤 18h35 맞았습니다!
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
        getPrimeNumbers(N); // 2 ~ N 사이의 모든 소수를 구해서 list에 담아둠
        kThSieve(N, K); // 에라토스테네스의 체에 따라 지워지는 수들을 차례로 linkedHashSet에 담음
        Integer[] sieveArr = sieveSet.toArray(new Integer[0]); // 지워진 수들 중 맨 마지막 요소에 접근하기 위해(set은 인덱스가 없음) 배열로 바꿈

        // 출력
        System.out.println(sieveArr[sieveArr.length - 1]); // 지워진 수들의 배열에서 가장 마지막 요소를 return/출력
    }

    public static void kThSieve(int N, int K) {
        for (int i = 0; i < primeNumbers.size(); i++) {
            int thisPrimeNum = primeNumbers.get(i);
            int divisor = N / thisPrimeNum;

            // 2022.12.19(월) 18h5 계속 작성
            for (int j = 1; j <= divisor; j++) {
                sieveSet.add(j * thisPrimeNum);
//                System.out.println("j가 " + j + "일 때 지워진 수들의 set = " + sieveSet + " (크기는 " + sieveSet.size() + ")"); // todo
                if (sieveSet.size() == K) {
                    return;
                }
            }
        }
    }

    // 2 ~ N 사이의 모든 소수를 먼저 구함
    public static void getPrimeNumbers(int N) {
        primeNumbers.add(2);

        for (int i = 3; i <= N; i++) {
            boolean isPrimeNumber = true; // 2022.12.19(월) 18h20 실행 시 소수 [2, 3, 5, 7]만 담겨서 디버깅해봄 -> i가 11일 때 isPrimeNumber가 여전히 false임을 발견하고, 이 변수의 선언/초기화 위치 변경
            if (i % 2 == 0) continue;

            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) primeNumbers.add(i);
        }

//        System.out.println(primeNumbers); // todo
    }
}

/* 회고
1. 문제를 푼 다음 구글에서 몇 가지 솔루션/해설을 찾아본 결과, 나는 너무 글자 그대로 구현한 것 같다(e.g. 아직 지우지 않은 수 중 가장 작은 수는 소수이므로, 직접 소수를 구해서 활용함)
vs 아직 지우지 않은 수 중 가장 작은 수는 자연스럽게 소수이다
2. 소수의 목록을 구하는 함수의 로직은 어떤 수가 소수인지 아닌지 판별하는 로직과 동일하다 -> 내가 전에 완벽히 이해하지 못했기 때문에 잘못된 isPrimeNumber 선언/초기화 위치 등으로 시간을 많이 소모했다
3. 더 간단하고 단순/추상화된 방법으로 다시 작성해보자

ideation
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
