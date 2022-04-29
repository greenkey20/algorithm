package com.baekjoon.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

// 2022.4.28(목) 22h45 -> 2022.4.29(금) 23h50 제출 = 틀렸습니다(왜 그런지 잘 모르겠음) -> 2022.4.30(토) 1h10 제출 = 576ms 맞았습니다
public class Main_1157 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next().toUpperCase();
		
		HashMap hm = new HashMap();
		
		// 2022.4.30(토) 0h15 Eddie의 조언 = 가독성을 위해 input.charAt(i)를 변수에 대입해서 사용 -> 2022.4.30(토) 1h15 제출 = 564ms 맞았습니다
		for (int i = 0; i < input.length(); i++) {
			// Java의 정석 p.650 예제 11-33 참고
			char key = input.charAt(i);
			
			if (hm.containsKey(key)) {
				int count = (int)hm.get(key);
				hm.put(key, count + 1);
			} else {
				hm.put(key, 1);
			}
		}
		
//		System.out.println(hm); // 2022.4.29(금) 23h25 중간 점검(hm이 잘 만들어지나 확인)용 추가 
		
		// 2022.4.30(토) 1h15 아래 별도 메소드로 refactoring
		/*
		Iterator it = hm.entrySet().iterator();
		int max = 0; // 2022.4.30(토) 0h20 Eddie의 조언 = 일단 반례 abcc 처리한 뒤, max의 위치도 저장?(iterator 복사해서?)하는 것 생각해보기?
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			
			int count = (int)entry.getValue();
			
			// 2022.4.29(금) 23h50 시도1)
//			if (count > max) {
//				max = count;				
//			} else if (count == max && count != 0) {
//				System.out.println("?");
//				return; // 메소드 실행 종료/Java 함수에서 나가기 -> 2022.4.29(금) 23h50 틀린 이유 = 여기서 나가면 안 됨; 반례 abcc
//			}
			
			if (count >= max) {
				max = count;
			}
			
		}
		*/
		
		// 2022.4.29(금) 23h30 계속 풀이/추가 -> 시도1)
		/*
		if (hm.containsValue(max)) {
//			System.out.println("가장 많이 사용된 알파벳이 1개만 있는 경우, 여기로 오지요");
			System.out.println(getKey(hm, max));
		}
		*/
		// 2022.4.30(토) 1h 시도2)
		if (getKey(hm, getMax(hm)).size() > 1) {
			System.out.println("?");
		} else {
			System.out.println(getKey(hm, getMax(hm)).get(0));
		}
		
		sc.close();
		
	} // main() 종료
	
	// 2022.4.30(토) 1h15 refactoring -> 1h20 제출 = 572ms 맞았습니다
	public static int getMax(Map map) {
		Iterator it = map.entrySet().iterator();
		int max = 0;
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			
			int count = (int)entry.getValue();
			
			// 2022.4.29(금) 23h50 시도1)
//			if (count > max) {
//				max = count;				
//			} else if (count == max && count != 0) {
//				System.out.println("?");
//				return; // 메소드 실행 종료/Java 함수에서 나가기 -> 2022.4.29(금) 23h50 틀린 이유 = 여기서 나가면 안 됨; 반례 abcc
//			}
			
			if (count >= max) {
				max = count;
			}
		}
		
		return max;
	}
	
	// 2022.4.29(금) 23h35 추가
	// 참고: https://rios.tistory.com/entry/JAVA-hashMap-key%EA%B0%92%EC%9C%BC%EB%A1%9C-value-%EC%B0%BE%EA%B8%B0-value%EB%A1%9C-key%EA%B0%92-%EC%B0%BE%EA%B8%B0
	public static ArrayList getKey(Map map, int count) {
		// 시도1)
		/*
		for (char key : (char)map.keySet()) { // 빨간줄 = Can only iterate over an array or an instance of java.lang.Iterable
			if ((int)map.get(key) == count) {
				return key;
			}
		}
		*/
		
		// 2022.4.30(토) 0h40 추가
		ArrayList list = new ArrayList();
		
		// 2022.4.29(금) 23h50 시도2)
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			
			if ((int)entry.getValue() == count) {
//				return (char)entry.getKey();
				
				// 2022.4.30(토) 0h45 시도3)
				list.add((char)entry.getKey());
			}
		}
		
		return list;
	}

}
