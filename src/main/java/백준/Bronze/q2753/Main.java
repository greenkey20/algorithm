package 백준.Bronze.q2753;

import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		// 2022.12.3(토) 10h refactoring
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(checkLeapYear(year));

		br.close();
		bw.flush();
		bw.close();
	}

	/* 2022.12.3(토) 10h refactoring
	1. 자료 입/출력 부분 제외하고, 문제 풀이 로직을 재활용할 수 있도록 별도 메서드 분리해두기
	2. 좀 더 효율적인 입/출력 방법 사용
	 */
	public static String checkLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0)) {
			return "1"; // 윤년입니다
		} else {
			return "0"; // 윤년이 아닙니다
		}
	}	
}