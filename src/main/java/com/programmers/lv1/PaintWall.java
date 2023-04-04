package com.programmers.lv1;

// 2023.4.4(화) 19h35 ~ 19h45 v1 54.0 반례가 어떤 경우로 있을까?
public class PaintWall {
    public static int solution(int n, int m, int[] section) {
        // 페인트를 다시 칠해야 하는 section 배열의 원소들은 오름차순으로 정렬되어 있음 + 같은 원소가 2번 이상 나타나지 않음
        int diff = section[section.length - 1] - section[0] + 1;
        int answer = diff / m;

        if (diff % m == 0) {
            return answer;
        } else {
            return answer + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[]{2, 3, 6}));
        System.out.println(solution(5, 4, new int[]{1, 3}));
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4}));
    }
}
