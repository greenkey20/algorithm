package com.baekjoon.control;

import java.util.Scanner;

// 2022.4.23(토) 23h45 -> 23h53 제출 = 204ms 맞았습니다
public class Main_2562 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] iArray = new int[9]; // 길이/크기가 9인 int 배열 선언 및 생성
		
		for (int i = 0; i < 9; i++) {
//			System.out.print("iArray의 " + (i + 1) + "번째 요소로 넣을 정수 1개를 입력해 주세요 > ");
			iArray[i] = sc.nextInt();
		}
		
		int max = iArray[0];
		int index = 0;
		
		for (int i = 1; i < 9; i++) {
			if (iArray[i] >= max) {
				max = iArray[i];
				index = i;
			}
		}
		
		System.out.println(max);
		System.out.println(index + 1);
		
		sc.close();
		
	}

}
