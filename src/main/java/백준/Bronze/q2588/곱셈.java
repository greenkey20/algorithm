package 백준.Bronze.q2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2022.11.28(월) 11h15
-> 11h30 나의 질문
1. 백준허브 크롬 extension으로 자동 커밋된 내역을 local로 pull해서 가져왔는데, java 파일에 public 클래스가 하나도 없어도 프로그램 동작에 지장 없나?
2. 나의 질문public 클래스 이름은 java 파일명과 동일해야 한다고 하는데, 왜 그런 거지?
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        int step1 = 0;
        int step2 = 0;
        int step3 = 0;

        step1 = num1 * (num2 % 10);
        step2 = num1 * (num2 / 10 % 10);
        step3 = num1 * (num2 / 10 / 10);

        int product = num1 * num2;

        System.out.println(step1);
        System.out.println(step2);
        System.out.println(step3);
        System.out.println(product);
    }
}
