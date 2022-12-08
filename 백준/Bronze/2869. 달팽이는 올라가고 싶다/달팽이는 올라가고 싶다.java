import java.io.*;

// 2022.12.5(월) 10h30
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int A = Integer.parseInt(inputs[0]); // 낮에 A미터 올라감
        int B = Integer.parseInt(inputs[1]); // 밤에 잠을 자는 동안 B미터 미끄러짐
        int V = Integer.parseInt(inputs[2]); // 높이가 V미터인 나무 막대

        // 문제 해결

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(calculateNumOfDaysToV(A, B, V)));

        bw.flush();
        bw.close();
        br.close();
    }

    // 문제 해결 로직
    public static int calculateNumOfDaysToV(int A, int B, int V) {
        int realHeight = V - A;
        int realMove = A - B;

        return (int) Math.ceil((double) realHeight / realMove) + 1;
    }
}
