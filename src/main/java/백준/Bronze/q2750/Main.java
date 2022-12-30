package 백준.Bronze.q2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 선택 정렬 알고리즘 구현
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    // arr[i]와 arr[j]의 자리 바꾸기
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        // 문제에서 요구하는 출력 = 1~n번째 줄에 오름차순으로 정렬한 결과를 1줄에 숫자 1개씩 출력
        // 2022.11.21(월) 13h40 v2 = 좀 더 효율적인 출력 방식1
        StringBuilder sb = new StringBuilder();

        // 2022.11.21(월) 13h50 v2 = 좀 더 효율적인 출력 방식2
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i : arr) {
//            System.out.println(i);
            sb.append(i).append("\n");

            //bw.write(i);
            //bw.newLine();
        }
        System.out.println(sb);

        //br.close();
        //bw.flush();
        //bw.close();
    }
}