package com.baekjoon.bruteforce;

import java.util.Scanner;

/**
 * 2022.6.3(금) 23h55
 * @author greenpianorabbit
 * 종말의 숫자 = 적어도 3개의 연속된 '6'이 들어가는 수 -> n(입력; 10,000보다 작거나 같은 자연수)번째로 작은 종말의 숫자 출력
 * e.g. 1 입력 -> 666 출력, 2 입력 -> 1666 출력, .., 10 입력 -> 9666 출력, 11 입력 -> 10666 출력..
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
		
		// v1) 이렇게 하면 첫번째 종말의 숫자 666만 출력할 수 있음 ㅠ.ㅠ
		// i 크기 조건을 그저 충분히 큰 수로 지정하고자 했더니, The literal 999999999999 of type int is out of range
		/*
		for (int i = 666; i < 1000000000; i++) {
			if (String.valueOf(i).contains("666")) {
				count += 1;
				if (count == n) {
					System.out.println(i);
				} else {
					count--;
					continue;
				}
			} else {
				continue;
			}
		}
		*/
		
		// 2022.6.5(일) 23h55
		for (int i = 666; i < 1000000000; i++) {
			
			
		}
		
//		sc.close();
	}

}
