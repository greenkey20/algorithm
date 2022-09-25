package com.baekjoon.lv1.control;

import java.util.Scanner;

// 2022.4.26(화) 22h50
public class Main_2908 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
		// 시도1) 23h 216ms 맞았습니다
		/*
		int n1 = sc.nextInt(); // 비교하고자 하는 숫자(number)1
		int n2 = sc.nextInt(); // 비교하고자 하는 숫자2
				
		String m1 = ""; // 상수가 '실수(mistake)'로 읽게 되는 숫자1
		for (int i = 0; i < 3; i++) {
			m1 += String.valueOf(n1).charAt(2 - i);
		}
		
		String m2 = ""; // 상수가 실수로 읽게 되는 숫자2
		for (int i = 0; i < 3; i++) {
			m2 += String.valueOf(n2).charAt(2 - i);
		}
		
		if (Integer.parseInt(m1) > Integer.parseInt(m2)) {
			System.out.println(m1);
		} else {
			System.out.println(m2);
		}
		*/
		
		/* 나의 생각 = m1, m2에 대입할 문자열 리터럴을 만드는 로직이 동일한 바, 코드가 반복되는데, 어떻게 중복을 없앨 수 있을까?
		 * 시도2) 23h12 208ms 맞았습니다
		 */
		
		String m01 = "";
		String m02 = "";
		
		for (int i = 0; i < 2; i++) { // 2개의 수를 비교하고자 하므로, 반복 2번만 돌림
			int n = sc.nextInt();
			
			String m = "";
			for (int j = 0; j < 3; j++) {
				m += String.valueOf(n).charAt(2 - j);
			}
			
			if (i == 1) {
				m01 = m;
			} else {
				m02 = m;
			}
		}
		
		if (Integer.parseInt(m01) > Integer.parseInt(m02)) {
			System.out.println(m01);
		} else {
			System.out.println(m02);
		}
		
		sc.close();
	}

}
