package com.baekjoon.bruteforce;

import java.util.Scanner;

// 2022.5.19(목) 23h50 -> 2022.5.20(금) 0h35 왜 틀리는지 잘 모르겠음 ㅠ.ㅠ
public class Main_7568 {
	
	// brute force
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 전체 사람의 수; 2 ≤ n ≤ 50
		int[][] list = new int[n][2];
		int[] ranks = new int[n];
		
		for (int i = 0; i < n; i++) {
			list[i][0] = sc.nextInt(); // 각 사람의 몸무게(10~200 범위의 양의 정수)
			list[i][1] = sc.nextInt(); // 각 사람의 키(10~200 범위의 양의 정수)
			ranks[i] = 0; // '질문 검색' 보다가 든 생각 = 이 배열 따로 안 만들고, 각 사람의 등수 값을 list 원소 배열의 3번째 원소에 넣는 게 나은 듯..?!
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (list[i][0] <= list[j][0] && list[i][1] <= list[j][1]) { // 나(i 반복문으로 선택된 사람)의 덩치가 타인(j 반복문으로 선택된 사람)의 덩치보다 같거나 작은 경우, 나의 등수 커짐
						ranks[i] += 1;
					}
				}
			}
		}
		
		String output = "";
		for (int i = 0; i < n; i++) {
			output += ranks[i] + 1 + " ";
		}
		
		System.out.println(output.trim()); // trim() = 문자열의 왼/오른쪽 끝에 있는 공백을 없앤 결과 반환; 문자열 중간에 있는 공백은 제거되지 않음
		
		sc.close();
	}

}
