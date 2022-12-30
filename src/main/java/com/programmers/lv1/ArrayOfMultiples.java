package com.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2022.11.25(금) 12h
public class ArrayOfMultiples {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int check = arr[i];
            if (check % divisor == 0) answerList.add(check);
        }

        if (answerList.size() != 0) {
            int[] answer = new int[answerList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            Arrays.sort(answer); // 나의 고민/질문 = 배열 or 리스트에 대해 sort()하는 것이 더 나은가?
            return answer;
        } else {
            return new int[]{-1};
        }
    }

    // 2022.11.25(금) 14h Stream 사용한 다른 사람의 풀이
    public int[] solutionReference1(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(el -> el % divisor == 0).toArray();
        if (answer.length == 0) answer = new int[]{-1};
        Arrays.sort(answer);
        return answer;
    }

    /* 회고
    1. 최근/이번주 코플릿 데일리코딩을 통해 문제를 '푼다', '문제 풀이 연습을 한다'기보다는, 레퍼런스를 읽고 이해하(려고 애쓰)기만 해서, 문제를 풀고 싶어서 프로그래머스로 와서 lv1 문제를 하나 푼 것이다
    2. Java Stream API에 더 익숙해지자
    3. Array vs List의 sort() 원리/성능 확인해보자
     */
}
