package com.programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2023.1.13(금) 8h
public class ClawCraneGame {
    public static int solution(int[][] board, int[] moves) {
        /* 입/출력 예시
        2차원 배열 board
        [0,0,0,0,0]
        [0,0,1,0,3]
        [0,2,5,0,1]
        [4,2,4,4,2]
        [3,5,1,3,1]

        1~5번 위치별 stack 만들기
         */
        int boardSize = board.length;
        List<Stack<Integer>> craneStacks = new ArrayList<>();

        for (int i = 0; i < boardSize; i++) {
            craneStacks.add(new Stack<Integer>());

            for (int j = 0; j < boardSize; j++) {
                int thisElement = board[boardSize - j - 1][i];
                if (thisElement != 0) {
                    craneStacks.get(i).add(thisElement);
                }
            }
        }

        List<Integer> basket = new ArrayList<>();
        basket.add(craneStacks.get(moves[0] - 1).pop());
        int answer = 0;

        for (int i = 1; i < moves.length; i++) {
            int thisPosition = moves[i] - 1;
            Stack<Integer> thisStack = craneStacks.get(thisPosition);

            if (!thisStack.isEmpty()) {
                int thisToy = thisStack.pop();

                if (thisToy == basket.get(basket.size() - 1)) {
                    answer++;
                    basket.remove(basket.size() - 1);
                } else {
                    basket.add(thisToy);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4})); // 4 vs 8h55 테스트 시 2
    }
}
