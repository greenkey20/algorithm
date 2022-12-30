package 백준.Silver.q1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022.12.19(월) 18h55
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        // 문제 해결 로직

        // 출력
        System.out.println(lengthOfNewNum(N));
    }

    public static int lengthOfNewNum(String N) {
        int lengthOfN = N.length();
        int numN = Integer.parseInt(N);

        int lengthOfNewNum = 0;

        for (int i = lengthOfN; i > 0; i--) {
            if (i != lengthOfN) {
                lengthOfNewNum += 9 * Math.pow(10, i - 1) * i;
            } else {
                lengthOfNewNum += (numN - Math.pow(10, i - 1) + 1) * i;
            }
        }

        return lengthOfNewNum;
    }
}
