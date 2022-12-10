package com.baekjoon.lv1bronze.inputoutput;

import java.util.Scanner;

// 2022.4.8(금) 3h55
public class Main_10953 {
	
	public static void main(String[] args) {
		
		/* 입력 = 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. A와 B는 콤마(,)로 구분되어 있다. (0 < A, B < 10)
		 * 출력 = 각 테스트 케이스마다 A+B를 출력한다.
		 */
		
		// 문제 질문 검색 참고해서 작성1 -> 런타임 에러(NumberFormat)
		/*
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
//			String input = "";
			
			String a = sc.next();
			
			while (Integer.parseInt(a) <= 0 || Integer.parseInt(a) >= 10) {
				a = sc.next();
			}
			
//			input += a + ",";
			
			String b = sc.next();
			
			while (Integer.parseInt(b) <= 0 || Integer.parseInt(b) >= 10) {
				b = sc.next();
			}
			
//			input += b;
			
			System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
			
		}
		*/
		
		// 작성2 -> 4h20 런타임 에러(InputMismatch)
		/*
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			
			while (a <= 0 || a >= 10) {
				a = sc.nextInt();
			}
			
			int b = sc.nextInt();
			
			while (b <= 0 || b >= 10) {
				b = sc.nextInt();
			}
			
			System.out.println(a + b);
		}
		*/
		
		// 문제 질문 봤을 때 idea
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 2022.4.9(토) 18h10 작성3
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < t; i++) {
//			System.out.println("덧셈 피연산자 '정수1,정수2' 형식으로 2개의 정수를 입력해주세요 > "); // 이 행도 썼을 때 채점 결과 = '출력 초과'(https://help.acmicpc.net/judge/info 프로그램이 너무 많은 출력을 하는 경우에 발생합니다. 이 결과는 '틀렸습니다'와 같은 의미를 갖습니다. 정확하게는 미리 구해놓은 정답 파일 크기의 2배를 넘어가면 이 결과를 받게 됩니다. 만약, 출력하는 부분이 무한 루프에 빠진 경우, 시간을 초과하기 전에 '출력 초과'를 받을 수 있습니다)
			String input = sc.nextLine();
			
			System.out.println(Integer.parseInt(input.split(",")[0]) + Integer.parseInt(input.split(",")[1]));
		}
		
//		System.out.println("프로그램 종료");
		
	}

}
