package com.baekjoon.string;

import java.util.Scanner;

// 2022.5.3(화) 23h30 -> 23h40 224ms 맞았습니다
public class Main_10809 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine().toLowerCase();
		
		/* 각각의 알파벳에 대해서 a, b, .., z가 처음 등장하는 위치를 공백으로 구분해서 출력
		 * 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치 + 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력
		 */
		for (int i = 97; i <= 122; i++) { // ASCII table 참조해서 소문자 알파벳 a~z의 10진수 값 찾아옴
			System.out.print(s.indexOf(i) + " "); // int indexOf(int ch)
		}
		
		sc.close();
	}

}
