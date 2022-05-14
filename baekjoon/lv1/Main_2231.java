package com.baekjoon.string;

import java.util.Scanner;

// 2022.5.9(월) 23h35 -> 2022.5.10(화) 23h25 328ms 맞았습니다
public class Main_2231 {
	
	// brute force
	public static void main(String[] main) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 입력 = 1~1,000,000 사이의 자연수 = 분해합
		
		// n의 가장 작은 생성자 m 찾기; n에 따라 생성자가 없을 수도 있고, 여러 개일 수도 있음
		
		// issue1) 자연수의 각 자리 수 구하기
		for (int m = 1; m <= n; m++) {
			/* 2022.5.10(화) 22h45
			 * 정수를 문자열로 변환
			 * 방법1) Integer.toString() <- toString() = 인스턴스/클래스에 대한 정보나 인스턴스 변수에 저장된 값들을 문자열(String)로 변환해서 반환
			 * 방법2) String.valueOf() = 지정된 값을 문자열로 변환해서 반환; 참조변수의 경우 toString()을 호출한 결과를 반환
			 * 방법3) 빈문자열 "" + 정수
			 */
			String mToString1 = Integer.toString(m);
//			String mToString2 = String.valueOf(m);
//			String mToString3 = m + "";
			
			int sum = 0;
			sum += m;
			
			for (int j = 0; j < mToString1.length(); j++) {
				/* issue2) charAt(i)의 결과로 받은 문자 '0~9'가 ASCII code로 인식되지 않도록
				 * 방법1) 2577문제 풀이 시 Character.getNumericValue() 메소드 사용
				 * 방법2) ASCII table 내용에 따라 '- 48'하면 내가 원하는 숫자를 얻을 수 있음(https://cokes.tistory.com/80 참고)
				 *  e.g. charAt(j)의 결과로 49가 반환된 경우, 그 자리 수는 '1' = 49 - 48 -> 나는 그 자리 수 '1'(o) 49(x)가 필요함
				 */
				sum += mToString1.charAt(j) - 48;
//				sum += Character.getNumericValue(mToString1.charAt(j)); // 2022.5.10(화) 23h35 404ms 맞았습니다
			}
			
			if (sum == n) { // n의 가장 작은 생성자 m을 찾은 경우
				System.out.println(m);
				return;
			}
			
		}
		
//		System.out.println(sum); // int sum = 0 선언 및 초기화를 위 for문(바깥 것) 밖에 하면, 반복문 돌 때마다 sum 계속 누적되어 의도치 않은 수가 됨
		
		// 생성자가 없는 경우 = 위 for문에서 m을 못 찾음
		System.out.println(0);
		
		sc.close();
	}

}
