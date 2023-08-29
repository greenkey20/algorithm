package com.book.successfuljobsearch;

// 2023.8.29(화) 17h40
public class FindPalindromes {
    public static void main(String[] args) {

    }

    /**
     * n부터 m 사이의 대칭수(121, 131, 123454321 등)를 찾는 코드를 작성하시오.
     * 0, 1, 2, .. 9도 대칭수라고 정의
     *
     * 처리해야 하는 예외 케이스
     * 1. n == m
     * 2. n 및 m이 음수로 주어진 경우
     *
     * @param n
     * @param m
     * @return
     */
    public static String findPalindromes(int n, int m) {
        // 시작점~끝점 구하기
        int start = Math.min(n, m);
        int end = Math.max(n, m);

        try {
            if (end < 0 || start < 0) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            System.out.println("Illegal Argument Exception이 발생했습니다.");
        }

        StringBuffer sb = new StringBuffer();

        // start~end 범위를 순회하면서 숫자(i의 값) 하나하나마다
        for (int i = start; i <= end; i++) {
            // i를 문자열로 바꿈 --[a]
            String iStr = String.valueOf(i);

            StringBuilder innerSb = new StringBuilder();
            // 해당 문자열의 끝에서부터 문자를 추출해서 새로운 문자열을 만듦 --[b]
            for (int j = iStr.length() - 1; j >= 0; j--) {
                char ch = iStr.charAt(j);
                innerSb.append(ch);
            }

            String reverseStr = innerSb.toString();

            // a와 b가 같으면 팰린드롬 -> sb.append(a).append(, )
            if (iStr.equals(reverseStr)) {
                sb.append(iStr).append(", ");
            }
        }

        return sb.toString();
    }
}
