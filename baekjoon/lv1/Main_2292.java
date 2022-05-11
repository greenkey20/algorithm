package com.baekjoon.control;

import java.util.Scanner;

// 2022.5.11(수) 23h20 종이에 메모하며 벌집 layer별 숫자(범위) 패턴 찾아냄 -> 23h40 구현 -> 23h55 204ms 맞았습니다
public class Main_2292 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 벌집의 중앙 1에서 n번 방까지; 1 ≤ n ≤ 1,000,000,000
		
		if (n == 1) {
			System.out.println("1");
		} else {
			int start = 2;
			int end = 1;
			
			// layer는 일단 충분히 큰 수로 해둠; n이 10억 이하의 정수라고 주어진 바, layer는 10억을 초과할 수 없기 때문에 10억으로 해둠
			for (int layer = 2; layer <= 1000000000; layer++) {
				start += (layer - 2) * 6;
				end = start + (layer - 1) * 6 - 1;
				
				if (start <= n && n <= end) {
					System.out.println(layer);
					return;
				}
			}
		}
		
		sc.close();
	}

}
