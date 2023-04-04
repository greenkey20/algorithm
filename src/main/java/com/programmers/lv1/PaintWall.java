package com.programmers.lv1;

// 2023.4.4(화) 19h35 ~ 19h45 v1 54.0 반례가 어떤 경우로 있을까?
// v2 연습장에 반례 생각하며 알고리즘 생각해봄
public class PaintWall {
    public static int solution(int n, int m, int[] section) {
        // 페인트를 다시 칠해야 하는 section 배열의 원소들은 오름차순으로 정렬되어 있음 + 같은 원소가 2번 이상 나타나지 않음
        int diff = section[section.length - 1] - section[0] + 1;
        // v2 위 diff 구간 중 안 칠해도 되는 구간의 번호들 구하기 -> 실행해본 뒤 입/출력 예시1 보니 diff 구간에서 누락된 숫자의 위치도 중요한 바, 아래 로직으로는 풀 수 없음
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < section.length; i++) {
            sb.append(section[i]);
        }
        System.out.println("section 배열을 문자열로 바꾼 것 = " + sb.toString());

        int count = 0;
        for (int i = section[0] + 1; i < section[section.length - 1]; i++) {
            String str = String.valueOf(i);

            if (!sb.toString().contains(str)) {
                count++;
            }
        }

        int answer = (diff - count) / m;

        if (diff % m == 0) {
            return answer;
        } else {
            return answer + 1;
        }
    }

    public static void main(String[] args) {
        // 프로그래머스 입/출력 예시
        System.out.println(solution(8, 4, new int[]{2, 3, 6})); // 2
        System.out.println(solution(5, 4, new int[]{1, 3})); // 1
        System.out.println(solution(4, 1, new int[]{1, 2, 3, 4})); // 4

        // 내가 v2 작성 시 만든 예시
        System.out.println(solution(11, 3, new int[]{2, 3, 4, 6, 7, 8, 10, 11})); // 3
    }
}
