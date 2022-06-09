package com.baekjoon.math;

import java.util.Scanner;

/**
 * 2022.6.8(수) 23h55
 * @author greenpianorabbit
 * 주어진 수(1,000 이하의 자연수) n(100 이하)개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램
 *
 */
public class Main_1978 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] iArray = new int[n];
		
		for (int i = 0; i < n; i++) {
			iArray[i] = sc.nextInt();
		}
		
		int count = 0;
		
		sc.close();
	}

}
