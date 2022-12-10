package com.baekjoon.lv2silver.math;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 2022.6.8(수) 23h55
 *
 * @author greenpianorabbit
 * 주어진 수(1,000 이하의 자연수) n(100 이하)개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램
 * <p>
 * 알고리즘 분류 = 수학; 정수론; 소수 판정; 에라토스테네스의 체
 */
public class Main_1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2022.6.9(목) 23h55
        int n = sc.nextInt();

        int[] inputs = new int[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = sc.nextInt();
        }

        int count = 0;

        /* 2022.6.10(금) 23h45
         * 1~1000 범위의 Eratosthenes의 체(sieve) 만들기 -> 1 + 2의 배수 + 3의 배수 + 5의 배수 + 7의 배수 + 11의 배수 + 13의 배수..(31 이하의 모든 소수의 배수; 단, 각 소수는 제외) 지우기
         *
         * 2022.6.11(토) 23h55 a theorem on prime numbers = 만약 n이 합성수(1보다 크면서 소수가 아닌 자연수)라면, n의 소인수(주어진 자연수를 나누어 떨어뜨리는 약수 중에서 소수인 것) 중 하나는 n^0.5/루트n보다 같거나 작다
         * 2022.6.13(월) 23h35 이 문제에서 입력으로 주어질 1000 이하의 자연수가 합성수라면, 이 합성수의 소인수는 루트1000(=31.62)보다 같거나 작다 -> 1000 이하의 모든 소수를 담은 배열 만들기
         * 31 이하의 자연수가 합성수라면, 이 합성수의 소인수는 루트31(=5.62)보다 같거나 작다 -> 1~31의 자연수 집합으로부터 1과 2/3/5의 배수(단, 2/3/5는 제외)를 제외하면 모든 소수를 구할 수 있음 ->
         * 5 이하의 자연수가 합성수라면, 이 합성수의 소인수는 루트5(=2.37)보다 같거나 작다 -> 1~5의 자연수 집합으로부터 1과 2의 배수(단, 2는 제외)를 제외하면 모든 소수를 구할 수 있음 -> 1~5의 자연수 집합의 모든 소수 = 2, 3, 5
         */

        // 2022.10.1(토) 23h30 -> 23h40 틀렸습니다 -> 참고 자료들(특히 https://st-lab.tistory.com/80) 구글링 -> 2022.10.2(일) 23h50 수정(7회 제출 ㅠㅠ) -> 2022.10.3(월) 0h10 맞았습니다
        /* 내가 놓쳤던 점
        1. isPrime flag(상태 저장 변수)를 외부for문 밖에 선언해두면, 내부for문에서 false로 바뀐 다음 더 이상 값이 업데이트되지 않음
        2. 내부for문에서 홀수만 검사하고자 했다면, 짝수 검사하는 조건문을 추가했어야 함
        3. 내부for문에서 break함으로써 반복 횟수 줄여야 했음 -> 이 break 없이도 동작은 함 + 백준에서 성능 차이도 크게 없어보임(break 했을 때 소요 시간 216ms, 메모리 17792KB vs 안 했을 때 소요 시간 220ms, 메모리 17824KB)
        -> 내가 이 로직을 안다고 생각하고 전반적으로 꼼꼼하게 구현하지 못했음
         */
        for (int i = 0; i < n; i++) {
            boolean isPrime = true;

            if (inputs[i] == 1) {
                continue; // unnecessary as the last statement in a loop
            } else if (inputs[i] == 2) {
                count++;
            } else if (inputs[i] % 2 == 0) {
                continue;
            } else {
                for (int j = 3; j <= Math.sqrt(inputs[i]); j += 2) {
                    if (inputs[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

//                isPrime = true;
                if (isPrime) {
                    count++;
                }
            }
        }

        System.out.println(count);

        sc.close();
    }

    /**
     * 2022.6.13(월) 23h35 Eratosthenes의 체(sieve) = 매개변수로 주어진 특정 자연수 이하의 모든 소수 집합(HashSet 자료형)을 반환하는 메소드
     * <p>
     * 소수들을 담을 자료형으로 Set 컬렉션을 사용한 이유 = 데이터가 중복되면 안 됨 + 순서는 크게 중요하지 않음
     *
     * @param input
     * @return
     */
    public static HashSet eratosthenesSieve(int input) {
        // 2022.6.15(수) 23h35
        int ceiling = (int) Math.floor(Math.pow(input, 2));

        eratosthenesSieve(ceiling);

        // 2022.6.14(화) 23h50
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < input; i++) {
            hs.add(i);
        }

//		int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

        return hs;
    }

    // 2022.6.15(수) 23h35
    public static int[] getAllPrimeNumbers(int input) {
        int[] result = new int[input];
        return result;
    }

}
