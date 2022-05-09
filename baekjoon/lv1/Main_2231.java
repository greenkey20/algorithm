package com.baekjoon.control;

import java.util.Scanner;

// 2022.5.9(월) 23h35
public class Main_2231 {
	
	// brute force
	public static void main(String[] main) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 입력 = 1~1,000,000 사이의 자연수 = 분해합
		
		// n의 가장 작은 생성자 m 찾기; n에 따라 생성자가 없을 수도 있고, 여러 개일 수도 있음
		int sum = 0;
		int m = 0;
		
		// issue1) 자연수의 각 자리 수 구하기
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		
		if (sum == n) { // 생성자가 있는 경우
			System.out.println(m);
		} else { // 생성자가 없는 경우
			System.out.println("0");
		}
		
		sc.close();
	}

}
