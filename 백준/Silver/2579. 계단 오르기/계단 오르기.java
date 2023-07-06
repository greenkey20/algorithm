import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023.7.6(목) 19h30 ~ 19h55 테스트 케이스 1개 확인 후 제출 = 틀렸습니다
public class Main {
    //    public static int n;
//    public static int[] scores;

    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 계단의 개수, 300 이하의 자연수

        int[] scores = new int[n]; // 각 10,000 이하의 자연수
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        // 문제 해결 로직
        int result = solution(n, scores);

        // 결과 출력
        System.out.println(result);
    }

    public static int solutionDraft(int n, int[] scores) {
        int[] dp = new int[n + 1]; // dp[i] = i번째 계단에 도달할 때까지 얻을 수 있는 총 점수의 최대 값
        dp[1] = scores[0];
//        int count = 1; // 테스트1은 통과x + 테스트2는 통과
        boolean is3Steps = false;

//        dp[2] = Math.max(dp[1] + scores[1], dp[0] + scores[1]);

        for (int i = 2; i <= n; i++) {
            int score1stepBehind = dp[i - 1];
            int score2stepsBehind = dp[i - 2];
            int scoreOfThisStep = scores[i - 1];

            if (is3Steps) {
                dp[i] = score2stepsBehind + scoreOfThisStep;
                is3Steps = false;
            } else {
                if (score1stepBehind + scoreOfThisStep > score2stepsBehind + scoreOfThisStep) {
                    dp[i] = score1stepBehind + scoreOfThisStep;
                    is3Steps = true;
                } else {
                    dp[i] = score2stepsBehind + scoreOfThisStep;
                }
            }

//            dp[i] = Math.max(dp[i - 1], dp[i - 2]) + scores[i - 1];
        }

        return dp[n];
    }

    // 2023.7.6(목) 23h30 reference https://st-lab.tistory.com/132 간단히 참고 후, 연습장에서 패턴 생각해보고 다시 풀어보기
    public static int solution(int n, int[] scores) {
        int[] dp = new int[n + 1];
        dp[1] = scores[0];
        if (n > 1) {
            dp[2] = scores[0] + scores[1];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 2]) + scores[i - 1];
        }

        return dp[n];
    }
}
