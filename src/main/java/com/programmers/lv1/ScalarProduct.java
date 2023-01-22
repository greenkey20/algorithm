package com.programmers.lv1;

import java.util.stream.IntStream;

public class ScalarProduct {
    // 2023.1.21(토) 15h5 -> 15h10 입/출력 예시 잘 동작하는 듯
    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
        System.out.println(solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1}));

        System.out.println(solutionReference(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
        System.out.println(solutionReference(new int[]{-1, 0, 1}, new int[]{1, 0, -1}));
    }

    // 다른 사람들의 풀이 = Stream으로 작성 -> 제출해봤는데 error: cannot find symbol 'variable IntStream' -> 나의 생각 = Java 버전 때문인가?
    public static int solutionReference(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
