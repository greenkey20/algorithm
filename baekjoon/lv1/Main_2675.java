package com.baekjoon.string;

import java.util.Scanner;

// 2022.4.25(월) 23h30 -> 23h40 시도1 = runtime error(no such element) -> 23h45 시도2 = 212ms 맞았습니다
/* 백준 help(https://help.acmicpc.net/judge/rte/NoSuchElement): java.util.NoSuchElementException는 존재하지 않는 것을 가져오려고 할 때 발생합니다.
 * Scanner에서 이 에러가 발생하는 경우는 더 이상 입력받을 수 있는 값이 없을 때입니다.
 */
public class Main_2675 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어짐
		
		for (int i = 0; i < t; i++) {
			int r = sc.nextInt(); // 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8)
			
			// 시도1)
			/*
			sc.nextLine(); // 개행 제거
			String s = sc.nextLine(); // + 문자열 S(길이는 적어도 1이며, 20글자를 넘지 않는다)가 공백으로 구분되어 주어짐
			*/
			
			// 시도2) googling 결과, https://bskwak.tistory.com/218에 따르면, '입력 과정에서 Enter 값을 입력받을 때까지 공백을 포함해서 1줄을 읽어보리기 때문에 nextLine()으로 입력받으면 안 된다' -> 23h45 현재 잘 이해는 안 됨
			String s = sc.next();
			
			String output = "";
			
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < r; k++) {
					output += s.charAt(j);
				}
			}
			
			System.out.println(output);
		}
		
		sc.close();
		
		/* 나의 생각
		 * 1. 테스트 케이스의 개수 t, 각 테스트 케이스의 반복 횟수 r, 문자열 s의 길이에 대한 조건문은 안 쓰고 우선 제출해봄
		 * 2. 'S에는 QR Code "alphanumeric" 문자만 들어있다. QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다'와 같은 조건이 문제에 있어서, 정규표현식을 써야 하나 처음에 고민했으나, 질문 검색을 간단히 살펴보니 필요 없는 것 같아 안 썼음
		 */
		
	}

}
