package Silver.q1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022.12.21(수) 8h5 v1 -> 9h array index out of bounds exception
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 주어지는 수 직사각형의 행의 개수/세로 길이
        int M = Integer.parseInt(firstLine[1]); // 직사각형의 열의 개수/가로 길이

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(br.readLine());
        }

        int[][] numbers = new int[N][M];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Character.getNumericValue(sb.charAt(idx));
                idx++;
            }
        }
        //System.out.println(Arrays.deepToString(numbers));
        // 이상 입력받은 수들을 N * M 크기의 int형 배열에 담음

        // 문제 해결 로직

        // 출력
        System.out.println(getLargestSquare(N, M, numbers));
    }

    // 2023.1.2(월) 7h50 구글링으로 레퍼런스 찾아 읽어본 뒤, 8h5 나 스스로 작성해보기
    public static int getLargestSquare(int N, int M, int[][] numbers) {
        int result = 1;
        int len = Math.min(N, M);

        while (len > 1) {
            for (int i = 0; i <= N - len; i++) {
                for (int j = 0; j <= M - len; j++) {
                    int topLeft = numbers[i][j];

                    if (topLeft == numbers[i][j + len - 1] && topLeft == numbers[i + len - 1][j] && topLeft == numbers[i + len - 1][j + len - 1]) {
                        result = len * len;
                        return result;
                    }
                }
            }

            len--;
        }

        return result;
    }
}