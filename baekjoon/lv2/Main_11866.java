package com.baekjoon.queue;

import java.util.Scanner;

/**
 * 2022.6.16(목) 23h50
 * @author greenpianorabbit
 * 요세푸스 문제 = 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 * 이제 순서대로 K번째 사람을 제거한다.
 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * 
 * N과 K가 주어지면(1 ≤ K ≤ N ≤ 1,000) (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오
 * 
 * 알고리즘 분류 = 구현; 자료 구조; queue
 * 
 * queue
 * stack
 * 원형 queue
 * 
 * 2022.6.21(화) 23h55
 * 이 문제에서 왜/어떻게 queue를 사용해야 하는가?
 */
public class Main_11866 {
	
	// 2022.6.20(월) 23h50
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // n명의 사람들이 앉아있음
		int k = sc.nextInt(); // k번째 사람을 제거함
		
		sc.close();
	}

}
