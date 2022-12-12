import java.io.*;

// 2022.12.12(월) 23h35
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 문제 해결 로직

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(cycleOfSums(N)));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int cycleOfSums(int N) {
        int left = 0;
        int right = 0;

        if (N < 10) {
            right = N;
        } else {
            left = N / 10;
            right = N % 10;
        }

        int sum = left + right;
        int count = 1;
        int newN = right * 10 + sum % 10;

        while (newN != N) {
            left = newN / 10;
            right = newN % 10;
            sum = left + right;

            newN = right * 10 + sum % 10;
            count++;
        }

        return count;
    }
}
