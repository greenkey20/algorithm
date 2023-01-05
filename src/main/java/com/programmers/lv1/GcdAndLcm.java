package com.programmers.lv1;

public class GcdAndLcm {
    // 2023.1.6(금) 7h40 -> 7h50 제출 시 반 정도 테스트케이스 통과 못함 -> 게시판 읽어봄 + https://devfoxstar.github.io/java/integer-compare-equals/
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int smaller = n;
        if (n > m) smaller = m;

        Integer gcd = 1;
        int lcm = 1;

        for (int i = smaller; i >= 2; i--) {
            Integer zero = 0;
//            if (n % i == 0 && m % i == 0) gcd = i;
            if (zero.equals(n % i) && zero.equals(m % i)) gcd = i;
        }

        if (gcd.equals(1)) lcm = n * m;
        else lcm = gcd * (n / gcd) * (m / gcd);

        answer[0] = gcd;
        answer[1] = lcm;

        return answer;
    }
}
