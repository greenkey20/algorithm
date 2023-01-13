package com.programmers.lv1;

import java.util.Arrays;

// 2023.1.14(토) 0h35 -> 30분 정도 v1 작성하고 실행 시 정확한 값 얻을 수 없음, 키를 누르고 그 위치로 손을 이동시켜야 함..
public class PressKeyPad {
    public static String solution(int[] numbers, String hand) {
        // 키패드를 다차원 배열로 표현
        int[][][] indiceOfKeys = new int[4][3][2];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                indiceOfKeys[i][j][0] = i;
                indiceOfKeys[i][j][1] = j;
            }
        }
//        System.out.println(Arrays.deepToString(indiceOfKeys));

        int currentPositionOfLeftHand = indiceOfKeys[3][0][0];
        int currentPositionOfRightHand = indiceOfKeys[3][2][0];

        // 누를 번호들을 순서대로 나열한 배열의 원소를 하나씩 순회하면서
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int thisNum = numbers[i];

            // 그 원소가 어떤 숫자인지에 따라 처리 방식 결정/수행
            if (thisNum % 3 == 2 || thisNum == 0) {
                int position = 0;
                switch (thisNum) {
                    case 2:
                        position = 0;
                        break;
                    case 5:
                        position = 1;
                        break;
                    case 8:
                        position = 2;
                        break;
                    case 0:
                        position = 3;
                }

                int leftDistance = Math.abs(currentPositionOfLeftHand - position);
                int rightDistance = Math.abs(currentPositionOfRightHand - position);

                if (leftDistance < rightDistance) {
                    sb.append("L");
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                    } else {
                        sb.append("R");
                    }
                }
            } else if (thisNum % 3 == 1) {
                sb.append("L");
            } else {
                sb.append("R");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
