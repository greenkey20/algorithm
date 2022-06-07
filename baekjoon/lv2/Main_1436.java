package com.baekjoon.bruteforce;

import java.util.Scanner;

/**
 * 2022.6.3(금) 23h55
 * @author greenpianorabbit
 * 종말의 숫자 = 적어도 3개의 연속된 '6'이 들어가는 수 -> n(입력; 10,000보다 작거나 같은 자연수)번째로 작은 종말의 숫자 출력
 * e.g. 1 입력 -> 666 출력, 2 입력 -> 1666 출력, .., 10 입력 -> 9666 출력, 11 입력 -> 10666 출력..
 * 
 * 메모리 제한 = 128MB
 */
public class Main_1436 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
//		int numToCompare = 666;
		int count = 0;
		
		/*
		while (true) {
			String stringToCompare = String.valueOf(numToCompare);
			
			if (stringToCompare.contains(n)) {
				count += 1;
				System.out.println(count);
			} else {
				numToCompare += 1;
			}
			
		}
		*/
		
		/* v1) 이렇게 하면 첫번째 종말의 숫자 666만 출력할 수 있음 ㅠ.ㅠ
		 * 
		 * 2022.6.6(월) 1h40 Eddie의 피드백
		 * 1. 현재 나의 프로그램에서 '프로그램 종료'는 언제 이루어지는 것인가?
		 * 2. continue -> 가독성 향상 + 여기서는 기능상 꼭 쓸 필요는 없음
		 * 
		 * Eddie와의 대화 중에 내 코드 다시 점검해보니 count-- 부분에 이상 있음 + 2개의 else문 필요 없음 감지 -> 2022.6.6(월) 23h35 v2 제출 = 메모리 초과
		 * 
		 */
		// i 크기 조건을, int 자료형의 표현 가능 범위에 대한 고려 없이, 그저 충분히 큰 수로 지정하고자 했더니, The literal 999999999999 of type int is out of range
//		for (int i = 666; i < 1000000000; i++) {
//			if (String.valueOf(i).contains("666")) {
//				count += 1;
//				if (count == n) {
//					System.out.println(i);
//				} /* else {
//					count--;
//					continue;
//				} */
//			} /* else {
//				continue;
//			} */
//		}
		
		// 2022.6.5(일) 23h55 여전히 아이디어가 잘 안 떠오르며 어떻게 풀어야 할지 잘 모르겠음 ㅠ.ㅠ
		/*
		for (int i = 666; i < 1000000000; i++) {
			
		}
		*/
		
		// 2022.6.7(화) 23h30 v3 -> 23h55 제출 = 의도한대로 프로그램 동작 안 함 + 메모리 초과
		for (int i = 666; i < 2100000000; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
//			System.out.println(sb);
			
			if (sb.indexOf("666") > 0) {
				count++;
				if (count == n) {
					System.out.println(i);
				}
			}
			
		}
		
//		sc.close();
	}

}
