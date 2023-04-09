import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static ArrayList<int[]> steps;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 문제 해결 로직
        StringBuilder sbResult = new StringBuilder();

        // 이동 횟수는 공식/점화식 이용해서 출력
        // n이 100일 때 long의 범위를 넘어감
        BigInteger count = new BigInteger("2");
        sbResult.append(count.pow(n).subtract(new BigInteger("1")));

        // n이 20 이하인 입력에 대해서는 두 번째 줄부터 수행 과정을 출력
        steps = new ArrayList<>();
        if (n <= 20) {
            sbResult.append("\n");
            hanoi(n, 1, 2, 3);

            for (int i = 0; i < steps.size(); i++) {
                int[] step = steps.get(i);
                sbResult.append(step[0] + " " + step[1] + "\n");
            }
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sbResult.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            steps.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, to, via);
            steps.add(new int[]{from, to});

            hanoi(n - 1, via, from, to);
        }
    }
}