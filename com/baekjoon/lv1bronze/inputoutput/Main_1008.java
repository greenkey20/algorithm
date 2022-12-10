package com.baekjoon.lv1bronze.inputoutput;

import java.util.Scanner;

//2022.4.7(목) 23h35 -> 23h40 맞았습니다
public class Main_1008 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		while (a <= 0 || a >= 10) {
			a = sc.nextInt();
		}
		
		int b = sc.nextInt();
		
		while (b <= 0 || b >= 10) {
			b = sc.nextInt();
		}
		
		// 첫째 줄에 A/B를 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10^-9 이이면 정답이다. 10^-9 이하의 오차를 허용한다는 말은 꼭 소수 9번째 자리까지만 출력하라는 뜻이 아니다.
		System.out.println((double)a/b);
		
	}

}
