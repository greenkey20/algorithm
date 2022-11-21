package com.baekjoon.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 2022.11.21(월) 10h
// 참고자료 출처: https://nahwasa.com/m/172
public class InputCodes {
    /* 백준 입력 예시
    3 // n = 이하 몇 줄이 있는지
    1 5 // 이하 각 line의 1번째 값 = 해당 line에 몇 개의 값이 있는지
    3 10 11 12
    5 1 2 3 4 5
     */
    // 입력 방법1) BufferedReader 및 StringTokenizer 사용
    public void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // StringTokenizer 생성자의 매개변수 = 데이터를 line 단위로 읽어온 것(String) -> 기본 구분자(공백, tab 문자, 줄바꿈, carriage-return character, form-feed character) 기준으로 문자열 자름
            int numOfItems = Integer.parseInt(st.nextToken());
            int[] intArr = new int[numOfItems];

            for (int j = 0; j < numOfItems; j++) {
                int item = Integer.parseInt(st.nextToken());
                System.out.println(item); // 2022.11.21(월) 10h45 나의 질문 = 실제 문제 풀 때는 이렇게 출력 안 해도 되는 거지..? 백준에서 이런 입력을 받아서 어떻게 활용하는 것인지 갑자기 헷갈리네..

                intArr[j] = item;
            }
            // 이상, 입력 i번째 행의 numOfItems개 데이터가 iArray 배열에 하나씩 담김 -> 입력 i+1번째 행으로 넘어가서 그 행의 numOfItems개만큼의 데이터를 읽음..
        }
    }

    // 입력 방법2) Scanner 및 String 클래스의 split() 사용
    public void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] dataStrArr = str.split(" ");
            int numOfItems = Integer.parseInt(dataStrArr[0]);
            int[] intArr = new int[numOfItems];

            for (int j = 1; j <= numOfItems; j++) {
                int item = Integer.parseInt(dataStrArr[j]);
                intArr[j - 1] = item;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new InputCodes().solution1();
        new InputCodes().solution2();
    }

}
