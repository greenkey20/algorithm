import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2023.7.2(일) 16h30
public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 10
        int k = Integer.parseInt(st.nextToken()); // 1 ≤ K ≤ 100,000,000

        // 문제 해결 로직
        // 주어진 동전들을 배열이나 리스트에 넣어두기
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println("주어진 동전의 종류 = " + Arrays.toString(coins)); // todo

        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int thisCoin = coins[i];
            if (k / thisCoin < 1) {
                continue;
            } else {
                int num = k / thisCoin;
                count += num;
                k -= thisCoin * num;

                if (k == 0) {
                    break;
                }
            }
        }

        // 결과 출력
        System.out.print(count);
    }

}
