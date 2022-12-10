package com.baekjoon.lv1bronze.string;

import java.util.Scanner;

// 2022.4.21(목) 23h45 단어 개수 -> 23h55 1차 제출 틀림 -> 2022.4.22(금) 0h10 508ms 맞았습니다
public class Main1152_V1 {
	
	public static void main(String[] args) {
		
		// 입력 = 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다.
		// 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열은 공백으로 시작하거나 끝날 수 있다.
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine(); // "                   "와 같이 공백으로만 이루어진 문자열이 input으로 입력된 경우 -> 문자열 words는 null/비어있음(x) ""(o) + 배열 wordArray는 [], wordArray.length = 1
		// 0h10 나의 생각 = 문제의 입력 조건에 따르면 "                   "와 같은 문자열은 입력으로 주어지지 않을 것 같음; Java11 '질문 검색' 조언에 따르면, 입력으로 빈칸 1개만 주어진 경우를 따져봐야 한다고 함
		
		String words = input.trim(); // input 문자열 왼/오른쪽 끝에 있는 공백을 제거한 문자열
//		System.out.println(words);
		// 방법1) words 문자열 내에 " "의 개수 + 1 = 단어의 개수
		// 방법2) words 문자열을 " "으로 구분해서 얻은 문자열 배열의 크기 = 단어의 개수
		String[] wordArray = words.split(" ");
//		System.out.println(Arrays.toString(wordArray));
		
		int wordCount = 0;
		if (!wordArray[0].equals("")) { // split() 함수 사용 시 이 조건이 필요한 이유 = https://st-lab.tistory.com/65
			wordCount = wordArray.length;
		} 
		
		System.out.println(wordCount);
	}

}

/* 문제 총평(https://st-lab.tistory.com/65)
보면 아주 단순한 문제다.
다만, 단순히 공백을 count 해주는 것이 아닌 예외의 케이스도 고려해야 한다는 점이 중요하다.
자바의 경우 StringTokenizer 클래스가 있어서 이를 알고 있다면 매우 쉬운 문제였을 것이다.
하지만 이 클래스를 몰라서 charAt()으로 반복하면서 처음과 마지막의 공백에 대하여 예외처리를 안하다보니 아무래도 정답률이 엄청 낮았던 것 같다.
 */
