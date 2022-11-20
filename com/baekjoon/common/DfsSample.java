package com.baekjoon.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022.10.15(토) 12h
// 참고자료 출처: https://nahwasa.com/m/172
public class DfsSample {
    /* psvm을 제출해야 하는데,
    static main()에는 인스턴스 멤버들을 사용할 수 없고 static/클래스 멤버들만 사용할 수 있으니까,
    main() 내용은 최소화하고, public solution() 함수로 한 번 래핑해서 만들어두면 좋음 -> 프로그래머스 등 다른 플랫폼에도 비슷하게 코드 재활용 가능
     */
    public static void main(String[] args) throws IOException {
        new DfsSample().solution();
    }

    // 인스턴스 변수
    private int max = 0;
    private int n, k;
    private int[] arr;

    // 멤버 메서드
    public void dfs(int cnt, int num) {
        if (cnt == 0)  return;

        num *= 10;
        if (num >= n) return;

        for (int i = 0; i < k; i++) {
            int tmp = num + arr[i];
            if (tmp > n) continue;
            if (tmp > max) max = tmp;
            dfs(cnt +1, tmp);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // br.readLine() 관련 예외 처리 필요
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);

        System.out.println(max);
    }
}
