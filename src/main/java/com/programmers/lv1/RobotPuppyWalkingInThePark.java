package com.programmers.lv1;

import java.util.Arrays;

// 2023.4.5(수) 23h ~ 23h30 v1 아직 완성 다 못함(공원 parkArr 그린 것과 출발점/현재 위치 설정은 잘 된 것 같음) + isOpen() 로직 잘못 생각함(maybe 도착점 뿐만 아니라, 경로에 장애물(-1) 없어야 이동 가능)
// maybe로부터 direction 방향 1~distance만큼 움직이며, 하나하나 위치에 -1 있으면, 해당 route는 실행x vs 그걸 다 통과해서 isOpen() true 반환 받았을 때 route 실행
public class RobotPuppyWalkingInThePark {
    static int[][] parkArr = null;

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // park를 int[][]로 그리기
        parkArr = new int[park.length][park[0].length()];
        int[] start = new int[2];

        for (int i = 0; i < park.length; i++) {
            String str = park[i];
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == 'S') {
                    start[0] = i;
                    start[1] = j;
                }

                if (ch == 'X') {
                    parkArr[i][j] = 1;
                } else {
                    parkArr[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(parkArr)); // todo
        System.out.println(Arrays.toString(start)); // todo

        // 강아지가 routes 명령어 하나하나에 따라 움직임
        int[] maybe = new int[2];
        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            String direction = route[0];
            Integer distance = Integer.parseInt(route[1]);

            if (direction.equals("N")) {
                maybe[0] = start[0] - distance;
                maybe[1] = start[1];

                if (maybe[0] >= 0 && isOpen(maybe)) {
                    start[0] -= distance;
                }
            } else if (direction.equals("S")) {
                maybe[0] = start[0] + distance;
                maybe[1] = start[1];

                if (maybe[0] <= parkArr.length && isOpen(maybe)) {
                    start[0] += distance;
                }
            } else if (direction.equals("W")) {
                maybe[0] = start[0];
                maybe[1] = start[0] - distance;

                if (maybe[0] >= 0 && isOpen(maybe)) {

                }
            }

        }

        return answer;
    }

    public static boolean isOpen(int[] maybe) {
        return parkArr[maybe[0]][maybe[1]] != 1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"})));
    }
}
