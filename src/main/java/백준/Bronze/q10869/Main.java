package 백준.Bronze.q10869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022.11.28(월) 11h
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // v2 입력 방식 수정
        String[] strs = br.readLine().split(" ");
        int A = Integer.parseInt(strs[0]);
        int B = Integer.parseInt(strs[1]);

        System.out.println(A + B);
        System.out.println(A - B);
        System.out.println(A * B);
        System.out.println(A / B);
        System.out.println(A % B);

        br.close();
    }
}
