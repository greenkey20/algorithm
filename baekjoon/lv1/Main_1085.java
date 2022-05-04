package com.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

// 2022.5.4(수) 0h5
public class Main_1085 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
//		int min = 0;
		
		// idea1) x, y, w - x, h - y를 크기 순으로(작은 정수 -> 큰 정수) 정렬해서 첫번째 원소 반환
		int[] iArray = {x, y, w - x, h - y};
		
		// 2022.5.4(수) 22h50 방법1) Java Arrays 클래스에서 제공하는 sort()(올림차순 정렬) 메소드 활용 -> 23h 208ms 맞았습니다
		Arrays.sort(iArray);
		/* public static void sort(int[] a) {
		        DualPivotQuicksort.sort(a, 0, 0, a.length);
		   }
		 */
//		System.out.println(Arrays.toString(iArray));
		
		// 방법2) bubble 정렬은 성능 안 좋지만, 만들어보기
		// 방법2) 보다 더 성능 좋은 quick 정렬 등 만들어보기
		
		System.out.println(iArray[0]);
		
		sc.close();
	}

}
