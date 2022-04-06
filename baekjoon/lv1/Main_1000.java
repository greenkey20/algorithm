package com.kh.inputOutput;

import java.util.Scanner;

// 2022.4.7(목) 2h40
public class Main_1000 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 백준 오답 처리
		/*
		System.out.print("1~9 중 하나의, 첫번째 정수를 입력해주세요 > ");
		int a = sc.nextInt();
		
		while (a <= 0 || a >= 10) {
			System.out.print("잘못된 범위의 정수입니다. 다시 입력해주세요 > ");
			a = sc.nextInt();
		}
		
		System.out.print("1~9 중 하나의, 두번째 정수를 입력해주세요 > ");
		int b = sc.nextInt();
		
		while (b <= 0 || b >= 10) {
			System.out.print("잘못된 범위의 정수입니다. 다시 입력해주세요 > ");
			b = sc.nextInt();
		}
		
		System.out.println("a + b = " + (a + b));
		*/
		
		// 백준 정답 처리
		int a = sc.nextInt();
		
		int b = sc.nextInt();
	
		System.out.println(a + b);
		
	}

}
