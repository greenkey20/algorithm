package com.baekjoon.control;

import java.util.Scanner;

// 2022.4.26(화) 23h20 -> 23h40 260ms 맞았습니다
public class Main_1546 {
	
	public static void main(String[] args) {
		// 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("시험 본 과목의 개수(1~1000의 자연수 1개)를 입력해 주세요 > ");
		int n = sc.nextInt();
		
		int[] scores = new int[n];
		
		int max = 0;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
//			System.out.print((i + 1) + "번째 과목의 점수를 입력해 주세요 > ");
			scores[i] = sc.nextInt();
			// 이상 시험 본 과목 n개에 대한 점수를 입력받음
			
			// 일단 세준이는 자기 점수 중에 최댓값(max)을 고름
			if (scores[i] >= max) {
				max = scores[i];
			}
			
			sum += scores[i];
		}
		
		// 그러고 나서 모든 점수를 점수/max*100으로 고침 -> 나의 생각 = 이렇게 점수를 고치는 로직 자체가 궁금함..
		double average = (double)sum / max * 100 / n;
		
		// 출력 = 첫째 줄에 새로운 평균을 출력; 실제 정답과 출력값의 절대/상대오차가 10^(-2) 이하이면 정답; 10^(-2) 이하의 오차를 허용한다는 말은 정확히 소수 2번째 자리까지 출력하라는 뜻이 아님 -> 나의 생각 = 정수(x) 실수(o) 자료형으로 출력하면 됨
		System.out.println(average);
		
		sc.close();
	}

}
