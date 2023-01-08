package com.programmers.lv1;

import java.util.Arrays;

public class Budget {
    // 2023.1.9(월) 7h30 -> 8h25 sout으로 확인 시 테스트케이스 결과대로 결과 찍히긴 하는데, 코드 이해 못하고 따라 친 것임ㅠㅠ
    public static int solution(int[] d, int budget) {
        int answer = 0;

        /* idea1 = d의 원소들을 오름차순으로 정렬(작은 수부터 더해야 보다 더 많은 원소들을 합산 가능)
        -> 첫번째 원소부터 하나씩 더해나가는데 budget의 크기와 같아질 때 멈추고, 그 때까지 몇 개의 원소를 더했는지를 반환
           d.length 중에서 (1 ~ d.length)개를 뽑는 조합을 만들어나가다가 그 합이 budget이 될 때의 depth? 반환
        -> 조합 구현 방법 googling
         */
        Arrays.sort(d);
        boolean[] visited = new boolean[d.length];

        int sum = 0;
        int i = 1;

        for (; i < d.length; i++) {
            if (combination1(d, visited, 0, i, budget)) {
                return i;
            }
        }

        return i;
    }

    public static boolean combination1(int[] d, boolean[] visited, int start, int i, int budget) {
        boolean result = false;

        if (i == 0) {
            return budget == sum(d, visited);
        }

        for (int j = start; j < d.length; j++) {
            visited[i] = true;
            result = combination1(d, visited, start + 1, i - 1, budget);
            visited[i] = false;
        }

        return result;
    }

    public static int sum(int[] d, boolean[] visited) {
        int sum = 0;

        for (int i = 0; i < d.length; i++) {
            if (visited[i]) {
                sum += d[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10));
    }
}
