package 백준.Bronze.q8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022.12.4(일) 6h
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(br.readLine());
        String[] testCases = new String[numOfTestCases];

        for (int i = 0; i < numOfTestCases; i++) {
            testCases[i] = br.readLine();
        }

        for (int i = 0; i < numOfTestCases; i++) {
            String testCase = testCases[i];

            // 문제 해결 로직
            // 6h20 v1 테스트 시 여기까지는 잘 동작하는 것 같은데, 출력이 제대로 안 됨

            // 출력
            System.out.println(calculateOxQuizScore(testCase));
        }

        br.close();
    }

    public static int calculateOxQuizScore(String testCase) {
        String[] seriesOfO = testCase.split("X");
        int score = 0;

        for (int i = 0; i < seriesOfO.length; i++) {
            if (!seriesOfO[i].equals("")) {
                for (int j = 1; j <= seriesOfO[i].length(); j++) {
                    score += j;
                }
            }
        }

        return score;
    }
}
