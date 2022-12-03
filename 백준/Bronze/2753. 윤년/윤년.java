import java.util.Scanner;

//2022.4.20(수) 23h30 윤년
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("연도(1~4000 범위의 정수 1개)를 입력해주세요 > ");
		int year = sc.nextInt();
		
		while (true) {
			if (year < 1 || year > 4000) {
//				System.out.print("잘못된 범위의 숫자입니다. 연도를 다시 입력해주세요 > ");
				year = sc.nextInt();
			} else {
				break;
			}
		}
		
		if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 400 == 0)) {
			System.out.println("1"); // 윤년입니다
		} else {
			System.out.println("0"); // 윤년이 아닙니다
		}
		
	}
	
}
