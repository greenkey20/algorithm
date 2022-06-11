package com.baekjoon.math;

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
		
		int[] iArray = new int[n];
		
		for (int i = 0; i < n; i++) {
			iArray[i] = sc.nextInt();
		}
		
		int count = 0;
		
		/* 2022.6.10(금) 23h45
		 * 1~1000 범위의 Eratosthenes의 체(sieve) 만들기 -> 1 + 2의 배수 + 3의 배수 + 5의 배수 + 7의 배수 + 11의 배수 + 13의 배수.. 지우기 
		 * 
		 * 2022.6.11(토) 23h55
		 * a theorem on prime number = 만약 n이 합성수(1보다 크면서 소수가 아닌 자연수)라면, n의 소인수(주어진 자연수를 나누어 떨어뜨리는 약수 중에서 소수인 것) 중 하나는 n^0.5/루트n보다 같거나 작다
		 */
		
		sc.close();
	}

}
