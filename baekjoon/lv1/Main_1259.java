package com.baekjoon.string;

import java.util.Scanner;

// 2022.5.17(화) 23h50 -> 2022.5.18(수) 0h15 216ms 맞았습니다
public class Main_1259 {
	/* 팰린드롬 = 뒤에서부터 읽어도 똑같은 단어
	 * 10도 팰린드롬 수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬 수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 정함
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String input = Integer.toString(sc.nextInt());
			String reverse = "";
			
			if (!input.equals("0")) {
				for (int i = 0; i < input.length(); i++) {
					reverse += input.charAt(input.length() - 1 - i);
				}
				
				if (input.equals(reverse)) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
				
			} else {
				sc.close(); // 프로그램 종료 전에만 자원 반납하면 됨
				return;
			}
			
		} // while문 영역 끝
		
//		sc.close(); // Unreachable code
	}
	
	/* 나의 생각
	 * 1. integer - String 자료형 변환 방법 숙지
	 */

}
