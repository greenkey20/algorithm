package com.baekjoon.lv1.control;

import java.util.Scanner;

//2022.4.21(목) 23h10 시험 성적 -> 23h15 208ms 맞았습니다
public class Main_9498 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수
//		System.out.print("시험 점수를 입력해 주세요 > ");
		int score = sc.nextInt();
		
		while (score < 0 || score > 100) {
//			System.out.print("잘못된 범위의 점수입니다. 시험 점수를 다시 입력해 주세요 > ");
			score = sc.nextInt();
		}
		
		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
	}

}
