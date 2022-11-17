package com.programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class makeHamburgers {
    // 2022.11.17(목) 2h25
    public int solution(int[] ingredients) {
        int answer = 0;

        /* stack을 하나 만들어 재료들을 쌓아두자
        ingredients[i] 요소가 1인 경우 -> stack.size(0)인 경우 ou stack.size(3)인 경우 stack에 마지막 빵 추가
        */

        // 2022.11.18(금) 8h30 계속해서 풀이/시도 -> 8h45 stack 어떻게 무엇을 쌓을지 고민하다가, 나 스스로는 풀기 어려울 것 같아 googling
        List<Stack<Integer>> hamburgers = new ArrayList<>();
        int breadCnt = 0;

        // ingredients 배열의 원소들을 하나하나 순회하면서
        for (int i = 0; i < ingredients.length; i++) {
            int ingredient = ingredients[i];
            Stack<Integer> hamburger = new Stack<>();

            if (ingredient == 1) {
                breadCnt++;
            }

            if (breadCnt % 2 == 0) {
                hamburger.push(ingredient);
                hamburgers.add(hamburger);
            } else {

            }

        }

        return answer;
    }
}
