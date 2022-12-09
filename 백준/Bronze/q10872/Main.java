package 백준.Bronze.q10872;

import java.io.*;

// 2022.12.8(목) 11h5 -> 11h15 아직 v1 작성 중
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 문제 해결 로직

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(calculateNFactorial(N)));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int calculateNFactorial(int N) {
        // 재귀 탈출 조건 = 문제가 더 이상 쪼개지지 않음
        if (N <= 1) return 1;

        // 문제가 더 작은 단위로 쪼개지는 경우
        return N * calculateNFactorial(N - 1);
    }
}
