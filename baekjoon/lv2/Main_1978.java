package com.baekjoon.math;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 2022.6.8(수) 23h55
 * @author greenpianorabbit
 * 주어진 수(1,000 이하의 자연수) n(100 이하)개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램
 * 
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
		
		sc.close();
	}
	
	/**
	 * 2022.6.13(월) 23h35 Eratosthenes의 체(sieve) = 매개변수로 주어진 특정 자연수 이하의 모든 소수 집합(HashSet 자료형)을 반환하는 메소드
	 * 
	 * 소수들을 담을 자료형으로 Set 컬렉션을 사용한 이유 = 데이터가 중복되면 안 됨 + 순서는 크게 중요하지 않음
	 * 
	 * @param input
	 * @return
	 */
	public static HashSet eratosthenesSieve(int input) {
		// 2022.6.15(수) 23h35
		int ceiling = (int)Math.floor(Math.pow(input, 2));
		
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
		
	}

}
