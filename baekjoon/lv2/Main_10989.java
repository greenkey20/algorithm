package com.baekjoon.sort;

import java.util.Scanner;

// 2022.5.22(일) 23h55
public class Main_10989 {
	
	// 주어진 n개의 수를 오름차순으로 정렬하는 프로그램
	public static void main(String[] args) {
		/* 정렬
		 * 1. 내 vs 외부 정렬
		 * 2. 안정적 vs 불안정적 정렬
		 * 3. 제자리 정렬
		 * 4. 비교 기반 vs 데이터 분포 기반 정렬
		 * 
		 * 기본 = 버블, 선택, 삽입, 셸 정렬
		 * 개선된 성능 = 합병, 퀵, 힙
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 수의 개수 n(1~1천만) 주어짐
		
		// n개의 수(10,000보다 작거나 같은 자연수)가 주어짐
		int[] input = new int[n];
		
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		
		// 방법1) 기본_버블 정렬
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				
			}
		}
		
		sc.close();
	}

}
