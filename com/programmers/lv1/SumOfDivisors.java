package com.programmers.lv1;

// 2022.12.30(금) 5h35 다른 사람의 풀이 참고해서 더 효율적인 반복문으로 풀어보기 -> 5h50 제출 시 통과
public class SumOfDivisors {
    public static int solution(int n) {
        int result = 0;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result += i;
                if (i != Math.sqrt(n)) {
                    result = result + n / i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }
}
