package com.baekjoon.control;

import java.util.Scanner;

// 2022.5.13(금) 23h40 -> 23h55 208ms 맞았습니다
public class Main_11050 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 자연수 n(1~10), 정수 k(0~n) -> 이항(binomial) 계수(coefficient)
		// knou '이산수학' 교재 및 wikipedia 정의 참조
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		if (k != 0) {
			int numerator = 1; // 분자
			
			for (int i = 0; i < k; i++) {
				numerator *= n - i;
			}
			
			int denominator = 1; // 분모
			
			for (int i = k; i > 0; i--) {
				denominator *= i;
			}
			
			System.out.println(numerator / denominator);
		} else {
//			System.out.println("0"); // 23h50 틀렸습니다 <- k가 0일 경우에 대해 내가 잘못 생각해서 잘못 구현함
			System.out.println("1");
		}
		
		sc.close();
	}

}
