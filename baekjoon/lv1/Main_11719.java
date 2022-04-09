package com.kh.inputOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 2022.4.9(토) 21h25
public class Main_11719 {
	/* 그대로 출력하기2
	 * 백준 guide = https://www.acmicpc.net/board/view/28332
	 * 문제의 포인트 = 파일의 끝(end of file, 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음)이 어디인지 판별하는 방법
	 * 
	 * Eddie의 조언
	 * 1. 코드 테스트 시, 내가 일일이 input 예시 입력(x) 파일에서 읽어오기(o) cf. https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
	 * 2. 입력 각 줄이 100글자를 넘지 않는다는 조건을 구현하면 동적으로 메모리(heap 영역) 할당이 되는 것을 방지함으로써 성능 향상 가능
	 */
	
	public static void main(String[] args) {
		// 테스트용
		/*
		File file = new File("C:\\workspace\\00_Exercises\\src\\com\\kh\\inputOutput\\resources\\input_11719.txt");
		
//		String output = "";
		// 22h 메모리 성능 향상을 위해 입력의 크기 지정
		char[] output = new char[100];
		
		try {
			Scanner sc = new Scanner(file);
			
			while (sc.hasNextLine()) {
//				output = sc.nextLine();
				
				// 22h 메모리 성능 향상을 위해 입력의 크기 지정 -> 22h25 for문 안 실행 내역 nextLine()에서 no such element exception(no line found) 발생하는데, 디버그 잘 못하겠음 ㅠ.ㅠ
				if (sc.nextLine().length() != 0) {
					for (int i = 0; i < sc.nextLine().length(); i++) {
						output[i] = sc.nextLine().charAt(i);
					}
				} else {
					output[0] = ' ';
				}
				
				System.out.println(output);
			}
			
			sc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		// 제출용 -> 21h50 맞음
		String output = "";
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			output = sc.nextLine();
			System.out.println(output);
		}
		
		sc.close();
		
	}

}
