package com.kh.control;

import java.util.Scanner;

// 2022.4.21(목) 23h20 기찍N -> 23h30 1076ms 맞았습니다
public class Main_2742 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("100,000보다 작거나 같은 자연수 1개를 입력해 주세요 > ");
		int n = sc.nextInt();
		
		while (n < 1 || n > 100000) {
//			System.out.print("1~100,000 범위의 자연수로 다시 입력해 주세요 > ");
			n = sc.nextInt();
		}
		
		for (int i = n; i > 0; i--) {
			System.out.println(i);
		}
		
		sc.close(); // 1차 채점 후 질문 목록 둘러보다가 추가 -> 다 사용한 자원 반납하자 >.<
		
	}

}
