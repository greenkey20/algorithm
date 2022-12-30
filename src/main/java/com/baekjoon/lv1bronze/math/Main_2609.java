package com.baekjoon.lv1bronze.math;

import java.util.Scanner;

// 2022.5.20(금) 23h50 -> 2022.5.21(토) 0h5 208ms 맞았습니다
public class Main_2609 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 첫째 줄에 두 개의 10,000 이하의 자연수가 주어짐 + 사이에 한 칸의 공백이 주어짐
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		int gcd = 0; // n1과 n2의 최대공약수(greatest common divisor) 
		
		// 10,000 이하의 자연수들의 최대공약수의 최대값은 10,000이므로, 반복문은 10000~1 사이 돌리기로 함
		for (int i = 10000; i >= 1; i--) {
			if (n1 % i == 0 && n2 % i == 0) {
				gcd = i;
				break;
			}
		}
		
		System.out.println(gcd); // 최대공약수 출력
		System.out.println(n1 / gcd * n2 / gcd * gcd); // 최소공배수 출력
		
		sc.close();
	}
	
	/* 나의 생각 = 문제 분류에 '유클리드 호제법'이 있어서 처음에는 이산수학 교과서에서 이론(?)을 찾아서 다시 공부해야 하나 싶었는데,
	 * 몇 초/잠시 생각해보니 유클리드 호제법 없이도 분모 값을 변화시켜가면서 최대공약수 구할 수 있을 것 같아 안 찾아보고 생각대로 위와 같이 구현해봄
	 */

}
