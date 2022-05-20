package com.baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// 2022.5.7(토) 23h35
public class Main_2798 {
	
	// brute force
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 카드의 개수 N; 3 ≤ N ≤ 100
		int m = sc.nextInt(); // 10 ≤ M ≤ 300,000
		
		// 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수 + 합이 m을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어짐
		int[] iArray = new int[n];
		
		for (int i = 0; i < n; i++) {
			iArray[i] = sc.nextInt();
		}
		
		Arrays.sort(iArray);
//		System.out.println(iArray); // [I@5f2050f6
		System.out.println(Arrays.toString(iArray));
		
		int sum = 0;
		
		for (int i = n - 1; i >= 2; i--) {
			
			for (int j = 1; j <= i - 1; j++) {
				
				for (int k = 2; k <= i - 2; k++) {
					sum = iArray[i] + iArray[i - j] + iArray[i - k];
					
					if (sum == m) {
						System.out.println(m);
						return;
					} else if (sum < m) {
						System.out.println(sum);
						return;
					} else {
						continue;
					}
				}
				
			}
			
		}
		
		/* 2022.5.8(일) 23h55 나의 생각 = 중첩 for문 돌아가는 것을 내가 정확하게 파악하고 있는가? 헷갈리면 돌 때마다 찍어보자..
		 */
		
		sc.close();
	}
	

}
