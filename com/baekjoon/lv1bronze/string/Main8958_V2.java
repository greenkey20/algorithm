package com.baekjoon.lv1bronze.string;

import java.io.*;

// 2022.12.4(일) 6h
public class Main8958_V2 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(br.readLine());
        String[] testCases = new String[numOfTestCases];

        for (int i = 0; i < numOfTestCases; i++) {
            testCases[i] = br.readLine();
        }

//        System.out.println(Arrays.toString(testCases));

//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < numOfTestCases; i++) {
            String testCase = testCases[i];

            // 문제 해결 로직
            // 6h20 v1 테스트 시 여기까지는 잘 동작하는 것 같은데, 출력이 제대로 안 됨

            // 출력
//            bw.write((int)calculateOxQuizScore(testCase)); // "공백 잔뜩 + 7" 출력됨 -> 왜 그런지, 출력되는 내용이 어떤 것을 의미하는지, 모르겠음
            System.out.println(calculateOxQuizScore(testCase));
        }

        br.close();
//        bw.flush();
//        bw.close();
    }

    public static int calculateOxQuizScore(String testCase) {
        String[] seriesOfO = testCase.split("X");
//        System.out.println(Arrays.toString(seriesOfO));
        int score = 0;

        for (int i = 0; i < seriesOfO.length; i++) {
            if (!seriesOfO[i].equals("")) {
                for (int j = 1; j <= seriesOfO[i].length(); j++) {
                    score += j;
//                    System.out.println((i + 1) + "번째 seriesOfO = " + seriesOfO[i] + ", score = " + score);
                }
            }
        }

        return score;
    }
}

/* 회고
1. 사실 문제 해결 로직은 올해 봄에 풀었던 것을 다시 읽어보지 않았다면 헤맷을 것 같다.. 여전히 String 다루는 것, split() 포함 유용한 메서드들 활용을 자유자재로 구상하고 구현하지 못하는 것 같다..
2. BufferedReader로 입력 받으니 확실히 수행 시간은 짧아졌다.
3. BufferedWriter 왜 제대로 출력 안 되는지 알아보자!
 */
