package com.baekjoon.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

// 2022.4.28(목) 22h45 -> 2022.4.29(금) 23h50 제출 = 틀렸습니다(왜 그런지 잘 모르겠음)
public class Main_1157 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next().toUpperCase();
		
		HashMap hm = new HashMap();
		
		for (int i = 0; i < input.length(); i++) {
			// Java의 정석 p.650 예제 11-33 참고
			if (hm.containsKey(input.charAt(i))) {
				int count = (int)hm.get(input.charAt(i));
				hm.put(input.charAt(i), count + 1);
			} else {
				hm.put(input.charAt(i), 1);
			}
		}
		
//		System.out.println(hm); // 2022.4.29(금) 23h25 중간 점검(hm이 잘 만들어지나 확인)용 추가 
		
		Iterator it = hm.entrySet().iterator();
		int max = 0;
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			
			int count = (int)entry.getValue();
			
			if (count > max) {
				max = count;				
			} else if (count == max && count != 0) {
				System.out.println("?");
				return; // 메소드 실행 종료/Java 함수에서 나가기
			}
		}
		
		// 2022.4.29(금) 23h30 계속 풀이/추가
		if (hm.containsValue(max)) {
//			System.out.println("가장 많이 사용된 알파벳이 1개만 있는 경우, 여기로 오지요");
			System.out.println(getKey(hm, max));
		}
		
		sc.close();
		
	} // main() 종료
	
	// 2022.4.29(금) 23h35 추가
	// 참고: https://rios.tistory.com/entry/JAVA-hashMap-key%EA%B0%92%EC%9C%BC%EB%A1%9C-value-%EC%B0%BE%EA%B8%B0-value%EB%A1%9C-key%EA%B0%92-%EC%B0%BE%EA%B8%B0
	public static char getKey(Map map, int count) {
		// 시도1)
		/*
		for (char key : (char)map.keySet()) { // 빨간줄 = Can only iterate over an array or an instance of java.lang.Iterable
			if ((int)map.get(key) == count) {
				return key;
			}
		}
		*/
		
		// 시도2)
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			
			if ((int)entry.getValue() == count) {
				return (char)entry.getKey();
			}
		}
		
		return '\u0000';
	}

}
