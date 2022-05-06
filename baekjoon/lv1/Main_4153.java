package com.baekjoon.control;

import java.util.Arrays;
import java.util.Scanner;

// 2022.5.5(목) 23h50 -> 23h55 정수 3개 입력받고 정렬 없이 직각삼각형 만드는 식으로 제출 시 '틀렸습니다' -> 2022.5.6(금) 22h35 216ms 맞았습니다
public class Main_4153 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] iArray = new int[3];
		
		while (true) {
			for (int i = 0; i < 3; i++) {
				iArray[i] = sc.nextInt(); // 각 테스트 케이스는 모두 30,000보다 작은 양의 정수로 주어짐
			}
			
			// 짧은 변 2개 vs 가장 긴 변(빗변) 1개 비교해야 하는 바, 오름차순 정렬
			Arrays.sort(iArray);
			
			if (iArray[0] + iArray[1] + iArray[2] == 0) { // 입력은 여러 개의 테스트 케이스로 주어지며, 마지막 줄에는 0 0 0이 입력됨
				break;
			} else {
				if (iArray[0] * iArray[0] + iArray[1] * iArray[1] == iArray[2] * iArray[2]) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}
			
		} // while문 영역 끝
		
		sc.close();
	}

}
