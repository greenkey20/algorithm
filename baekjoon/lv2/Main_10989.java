package com.baekjoon.sort;

import java.util.Scanner;

// 2022.5.22(일) 23h55
public class Main_10989 {
	
	/* 주어진 n개의 수를 오름차순으로 정렬하는 프로그램
	 * Java8 시간 제한 = 3000ms, 메모리 제한 = 512MB
	 */
	public static void main(String[] args) {
		/* 정렬
		 * 1. 내 vs 외부 정렬
		 * 2. 안정적 vs 불안정적 정렬
		 * 3. 제자리 정렬
		 * 4. 비교 기반 vs 데이터 분포 기반 정렬
		 * 
		 * 기본 = 버블, 선택, 삽입, 셸 정렬
		 * 개선된 성능 = 합병, 퀵, 힙
		 */
		
		// 2022.5.23(월) 23h50 v1
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 수의 개수 n(1~1천만) 주어짐
		
		// n개의 수(10,000보다 작거나 같은 자연수)가 주어짐
		int[] inputArray = new int[n];
		
		for (int i = 0; i < n; i++) {
			inputArray[i] = sc.nextInt();
		}
		
		// 방법1) 기본_버블 정렬 -> 시간 복잡도 성능 = O(n^2)
		for (int i = 0; i < n - 1; i++) { // (n - 1)번 반복문 돎 -> 마지막 반복 시 0번 인덱스에 최소값이 남아있음 
			for (int j = 0; j < n - 1 - i; j++) { // 반복문 돌 때마다 (맨 마지막 + 1) 원소는 비교에서 제외
				if (inputArray[j] > inputArray[j + 1]) { // 좌측의 값이 우측의 값보다 큰 경우 -> 좌측의 값(더 큰 숫자)을 우측 자리로 옮겨야 함 -> 오름차순 정렬
					int temp = inputArray[j];
					// v1) 아래와 같은 순서로 하면 자리 바꾸기가 안 되지 >.<
					/*
					input[j + 1] = temp;
					input[j] = input[j + 1];
					*/
					
					// 2022.5.24(화) v2) 0h25 수정 -> console 테스트 시 오름차순은 됨 -> 2022.5.24(화) 0h30 제출 = 시간 초과
					inputArray[j] = inputArray[j + 1];
					inputArray[j + 1] = temp;
				}
			}
		}
		
		/* 방법2) 합병 정렬
		 * 
		 * 2022.5.25(수) 23h50 v3
		 * 분할 정복 알고리즘을 적용 가능한 문제 중 하나
		 * 분할(입력의 크기가 n인 배열을 n/2개의 원소를 가진 2개의 부분배열로 분할) -> 정복(각각의 부분배열에 대해 합병 정렬을 순환적으로 적용해서 두 부분배열을 정렬) -> 결합(정렬된 두 부분배열을 합병해서 하나의 정렬된 배열을 만듦)
		 */
		
		for (int i = 0; i < n; i++) {
			System.out.println(inputArray[i]);
		}
		
		sc.close();
	}
	
	// 합병 정렬 메소드 구현
	public static int[] mergeSort(int[] inputArray, int n) {
		// 2022.5.28(토) 23h55 v5 + 2022.5.29(일) 0h5 v6
		
		// n이 1 이하인 경우/정렬해야 하는 (부분)배열의 원소의 수가 0 또는 1인 경우, 그 배열을 그대로 return하면 됨 vs n이 2 이상인 경우, 좌/우측 부분정렬로 나눠야 함
		if (n > 1) {
			int mid = n / 2;
			
			// 왼쪽 부분정렬 정의/만들기
			int[] leftArray = new int[mid];
			for (int i = 0; i < mid; i++) {
				leftArray[i] = inputArray[i];
			}
			
			leftArray = mergeSort(leftArray, mid); // 순환호출 대상인 mergeSort() 메소드를 this로 받을 수는 없는 듯..
			
			// 오른쪽 부분정렬 만들기
			int[] rightArray = new int[n - mid];
			for (int i = 0; i < n - mid; i++) {
				rightArray[i] = inputArray[mid + i];
			}
			
			rightArray = mergeSort(rightArray, n - mid);
			
			// 정렬된 두 부분배열의 합병
			inputArray = merge(leftArray, rightArray, mid, n);
		}
		
		return inputArray;
	}
	
	// 2022.5.26(목) 23h55 v4 sort() -> 2022.5.29(일) 0h5 v6 메소드명 수정 등 합병 함수/merge() 메소드 구현
	public static int[] merge(int[] leftArray, int[] rightArray, int mid, int n) {
		int[] mergedArray = new int[n];
		
		return mergedArray;
	}

}
