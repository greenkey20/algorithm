package com.baekjoon.control;

import java.util.Scanner;

// 2022.5.5(목) 23h50
public class Main_4153 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if (a * a + b * b == c * c) {
			System.out.println("right");
		} else {
			System.out.println("wrong");
		}
		
	}

}
