import java.io.*;
import java.util.*;

// 2023.4.11(화) 21h30
public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 문제 해결 = 정렬
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);

        // 출력 = 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i : arr) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
