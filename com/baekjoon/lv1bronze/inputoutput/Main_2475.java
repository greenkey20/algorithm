package com.baekjoon.lv1bronze.inputoutput;

import java.util.Scanner;

// 2022.4.19(화) 1h 검증 수
/* 숫자 5개 입력받기 -> 문제에서 요구한대로 5개 숫자들이 빈칸을 사이에 두고 나열되도록 하기 위해 String으로 입력받음
 * 입력받은 문자열의 홀수번째 자리에 있는 문자를 정수로 바꿔서 제곱하고 더함 -> 이 합계 값을 출력
 */
public class Main_2475 {
	
	public static void main(String[] args) {
		// 풀이1) 1h35 제출 -> 틀림
		/*
		String input = "";
		
		for (int i = 0; i < 5; i++) {
			input += (int)(Math.random() * 10) + " ";
		}
		
		System.out.println(input);
		
		int sum = 0;
		
		for (int i = 0; i < input.length(); i += 2) {
			sum += Integer.parseInt(String.valueOf(input.charAt(i))) * Integer.parseInt(String.valueOf(input.charAt(i)));
		}
		*/
		
//		System.out.println(sum);
		
		// 풀이2) 1h40 제출 -> 맞음
		String input = "";
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			input += sc.next() + " ";
		}
		
		int sum = 0;
		
		for (int i = 0; i < input.length(); i += 2) {
			sum += Integer.parseInt(String.valueOf(input.charAt(i))) * Integer.parseInt(String.valueOf(input.charAt(i)));
		}
		
		int verificationNo = sum % 10;
		System.out.println(verificationNo);
		
	}

}
