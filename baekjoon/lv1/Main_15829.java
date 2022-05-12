package com.baekjoon.string;

import java.util.Scanner;

// 2022.5.12(목) 23h30 -> 23h50 216ms 50점
public class Main_15829 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt(); // 문자열의 길이
		
		String key = sc.next(); // 영문/alphabet 소문자로만 이루어진 문자열이 들어온다.
		
		int sum = 0;
		
		// 해시 값(int h) 계산을 위한 r(알파벳 a~z에 부여할 정수 1~26보다 큰 소수인 31) 및 m(적당히 큰 수 -> 소수 1234567891) 값은 주어짐; r과 m은 서로소인 숫자로 정하는 것이 일반적임
		for (int i = 0; i < key.length(); i++) { // 나의 궁금증 = 'l == key.length()'인데, 문제에서는 왜 l을 따로 입력받는 것일까?
			sum += (key.charAt(i) - 96) * Math.pow(31, i); 
		}
		
		int h = sum % 1234567891;
		System.out.println(h);
		
		sc.close();
	}
	
	/* 나의 생각/궁금증
	 * 1. 문제에서 주어진 해시 함수를 왜 그렇게 만들었는지(r의 i승, mod m 등) 이해하고/알고 싶다..
	 * 2. 해시 함수의 다양한 응용 분야 알아보기
	 * 3. 문제 채점 시 small 50점(1 ≤ l ≤ 5), large 50점(1 ≤ l ≤ 50)의 의미는 무엇이지? 이 기준에 맞추려면 어떤 조건을 추가로 구현해야 하는 거지?
	 */

}
