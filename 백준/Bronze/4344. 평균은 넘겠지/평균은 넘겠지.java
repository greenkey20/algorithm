import java.io.*;

// 2022.12.4(일) 6h50
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        String[] testCases = new String[C];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < C; i++) {
            testCases[i] = br.readLine();

            // 문제 해결 로직

            // 출력
            bw.write(calculateRatioOfStudentsAboveAverage(testCases[i]));
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static String calculateRatioOfStudentsAboveAverage(String testCase) {
        String[] splits = testCase.split(" ");

        int numOfStudents = Integer.parseInt(splits[0]);

        int sum = 0;
        for (int i = 1; i < splits.length; i++) {
            sum += Integer.parseInt(splits[i]);
        }

        double average = sum / numOfStudents;

        int cnt = 0;
        for (int i = 1; i < splits.length; i++) {
            if (Integer.parseInt(splits[i]) > average) cnt++;
        }

        double ratioOfStudentsAboveAverage = (double) cnt / numOfStudents * 100;

        return String.format("%.3f%%%n", ratioOfStudentsAboveAverage);
    }
}
