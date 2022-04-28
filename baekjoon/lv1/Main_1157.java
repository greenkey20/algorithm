package com.baekjoon.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

// 2022.4.28(목) 22h45
public class Main_1157 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next().toLowerCase();
		
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
		
		Iterator it = hm.entrySet().iterator();
		int max = 0;
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			
			int count = (int)entry.getValue();
			
			if (count > max && count != 0) {
				max = count;				
			} else if (count == max && count != 0) {
				System.out.println("?");
			}
		}
		
	}

}
