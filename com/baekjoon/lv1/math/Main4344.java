package com.baekjoon.lv1.math;

import java.io.*;

// 2022.12.4(일) 6h50 -> 7h25 v1 제출 = 맞았습니다
public class Main4344 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
//        String[] testCases = new String[C]; // v1

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < C; i++) {
//            testCases[i] = br.readLine(); // v1

            // 문제 해결 로직

            // 출력
//            bw.write(calculateRatioOfStudentsAboveAverage(testCases[i])); // v1
            bw.write(calculateRatioOfStudentsAboveAverage(br.readLine())); // v2 = 정수 C를 입력받은 뒤에는 한 줄씩 입력받아 문제 해결 로직 메서드로 넘기면 됨 -> 그 결과를 출력
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static String calculateRatioOfStudentsAboveAverage(String testCase) {
        String[] splits = testCase.split(" ");

        int numOfStudents = Integer.parseInt(splits[0]);

        int sum = 0;
        for (int i = 1; i < splits.length; i++) {
            sum += Integer.parseInt(splits[i]);
        }

        double average = sum / numOfStudents;

        int cnt = 0;
        for (int i = 1; i < splits.length; i++) {
            if (Integer.parseInt(splits[i]) > average) cnt++;
        }

        double ratioOfStudentsAboveAverage = (double) cnt / numOfStudents * 100;

        return String.format("%.3f%%%n", ratioOfStudentsAboveAverage);
    }

    /* 회고
    1. 문제 입/출력 고민(이번 문제에서는 입력 시 언제 br.readLine()일지, 어디서 split(" ") 해야 할지 등 우왕좌왕.. 아마도 피곤해서..)에 시간이 꽤 소요되는데(문제 해결의 40% 정도?), 문제 더 풀다보면 익숙해지겠지..? 그리고 문제가 더 어려워지면 문제 해결 로직 짜는 데에 더 많은 시간이 들겠지..?
    2. 거의 밤을 새로 비몽사몽한 상태에서 풀었다. 이런 컨디션에서는 간단한 문제라도 뇌가 포기하고 싶어하는 것 같다는 느낌을 받았다
    3. 그래도 참고 차분하게 한 줄 한 줄 코딩해서 풀어낸 나, 참 잘 했어!
    4. 문제의 포인트 = 정수/실수 간 연산, String format(%를 percentage 의미로 쓰고 싶을 때 %%로 표기, 소수점 자리 수 등)
    5. 7h30 git commit 전 코드 한 번 훑어보니, 입력받을 때 굳이 String 배열 testCases 만들 필요 없는 것 같아, 코드 수정해서 v2 제출해보니 '맞았습니다'
     */
}
