package com.kh.inputOutput;

import java.util.Scanner;

// 2022.4.20(수) 23h20 두 수 비교 -> 23h25 맞았습니다
public class Main_1330 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a > b) {
			System.out.println(">");
		} else if (a < b) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
		
	}

}
