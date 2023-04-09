import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static ArrayList<int[]> steps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        steps = new ArrayList<>();

        // n이 100일 때 long의 범위를 넘어감
        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(n).subtract(new BigInteger("1")));

        // n이 20 이하인 입력에 대해서는 두 번째 줄부터 수행 과정을 출력
        if (n <= 20) {
            hanoi(n, 1, 3, 2);

            for (int i = 0; i < steps.size(); i++) {
                int[] step = steps.get(i);
                System.out.println(step[0] + " " + step[1]);
            }
        }
    }

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            steps.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, via, to);
            steps.add(new int[]{from, to});

            hanoi(n - 1, via, to, from);
        }
    }
}