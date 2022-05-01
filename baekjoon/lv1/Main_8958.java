package com.baekjoon.string;

import java.util.Arrays;
import java.util.Scanner;

// 2022.4.30(토) 1h30
public class Main_8958 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testNo = sc.nextInt();
		
		for (int i = 0; i < testNo; i++) { // testNo만큼 테스트 케이스 실행
			String result = sc.next(); // i번째 테스트 케이스 입력받음; 각 테스트 케이스는 1줄로 이루어져 있음 + 길이가 0보다 크고 80보다 작은 문자열이 주어짐 + 문자열은 O와 X만으로 이루어져 있음
			int score = 0;
			
			/*
			for (int j = 0; j < result.length(); j++) {
				if (String.valueOf(result.charAt(j)).equals("X")) {
					score += 0;
				}
			}
			*/
			
			/* 나의 생각 = Character.getNumericValue(char형 리터럴)의 성능 vs String.valueOf(char형 리터럴)의 성능? 
			 */
			
			// 2022.5.2(월) 0h15 계속 풀이 -> 0h35 228ms 맞았습니다
			String[] correct = result.split("X");
//			System.out.println(Arrays.toString(correct));
			
			for (int j = 0; j < correct.length; j++) {
				if (!correct[j].equals("")) {
					for (int k = 0; k < correct[j].length(); k++) {
						score += k + 1;
					}
				}
			}
			
			System.out.println(score);
		}
		
		sc.close();
	}

}
