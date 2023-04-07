package com.programmers.lv2;

// 2023.4.7(금) 19h55
/* 드디어(이제야 ㅠㅠ) lv2에 왔다..
최단 거리 찾는 문제 = bfs(너비 우선 탐색) = queue를 이용한 반복 구조로 표현
그래프 문제 풀려면 재귀, 정렬 등 백준 기본부터 이어서 연습하고 와야 할 듯..
 */
public class ShortestDistanceOnGameMap {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        if (maps[n - 2][m - 2] == 0 && maps[n - 2][m - 1] == 0 && maps[n - 1][m - 2] == 0) return -1;

        return answer;
    }

    public static void main(String[] args) {
        ShortestDistanceOnGameMap ob = new ShortestDistanceOnGameMap();
        System.out.println(ob.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}})); // 11
        System.out.println(ob.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}})); // -1
    }
}
