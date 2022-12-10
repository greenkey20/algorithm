package com.baekjoon.lv1bronze.math;

import java.io.*;

//2022.4.20(수) 23h30 윤년 -> 23h50 208ms 맞았습니다
public class Main_2753 {
	public static void main(String[] args) throws IOException {
		/*
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("연도(1~4000 범위의 정수 1개)를 입력해주세요 > ");
		int year = sc.nextInt();
		
		while (true) {
			if (year < 1 || year > 4000) {
//				System.out.print("잘못된 범위의 숫자입니다. 연도를 다시 입력해주세요 > ");
				year = sc.nextInt();
			} else {
				break;
			}
		}
		
		if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0)) {
			System.out.println("1"); // 윤년입니다
		} else {
			System.out.println("0"); // 윤년이 아닙니다
		}
		 */

		// 2022.12.3(토) 10h refactoring
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(checkLeapYear(year));

		br.close();
		bw.flush();
		bw.close();
	}

	/* 2022.12.3(토) 10h refactoring -> 10h10 제출 시 '맞았습니다'
	1. 자료 입/출력 부분 제외하고, 문제 풀이 로직을 재활용할 수 있도록 별도 메서드 분리해두기
	2. 좀 더 효율적인 입/출력 방법 사용

	결과 = 기존 방식 메모리 17748KB, 시간 208ms vs 오늘 코드 메모리 14292KB, 시간 128ms
	 */
	public static String checkLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0)) {
			return "1"; // 윤년입니다
		} else {
			return "0"; // 윤년이 아닙니다
		}
	}
	
}
