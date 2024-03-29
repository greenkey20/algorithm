package com.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleBox {
    // 2023.2.20(월) 20h ~ 20h35 v1 = 의도한대로 값 안 나옴 -> 2023.2.21(화) 17h50 ~ 18h v2 = 반복문 내 sout 찍어보는데 아직 의도하는대로 동작 안 함 = box에 담는 내용물의 index가 이상한 듯 -> 18h10 v3 여전히 의도한 결과x
    // score(품질)의 원소들은 1(최하품)~k(최상품) 범위의 정수들
    // 1상자에 사과를 m개씩 담아 포장
    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        // 이익이 발생하지 않는 경우 = 상자 0개 = m개가 담긴 상자를 1개도 만들 수 없음 -> return 0
        if (score.length < m) return answer;

        Arrays.sort(score);
        int[] scoreSortedDesc = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            scoreSortedDesc[i] = score[score.length - 1 - i];
        }
        System.out.println("score[] 배열을 내림차순한 것 = " + Arrays.toString(scoreSortedDesc)); // todo

        // 만들 수 있는 상자의 총 개수
        int numOfBoxes = scoreSortedDesc.length / m;

        // 포장한 상자들을 list에 담아둠
        List<int[]> boxes = new ArrayList<>();

        // 19h40 v5 상자 하나하나 포장하기 = 입/출력 예시에 대해서는 의도한 결과 도출됨 -> 그러나 제출 시 정확성 33.3% 뿐으로 '틀렸습니다' -> 19h50 나의 질문 = 반례는 무엇일까? 그 반례도 다룰 수 있도록 어떻게 추상화해야 하는 것일까?
        for (int i = 0; i < numOfBoxes; i++) {
            boxes.add(new int[m]);
            int[] box = boxes.get(i);

            // box 1개에 m개의 사과를 담음 -> 이 때 내림차순으로 정렬된 score[] 배열로부터 원소 1개씩 순차적으로 꺼내어 담음
            for (int j = 0; j < m; j++) {
                box[j] = scoreSortedDesc[i * 3 + j];
            }
            System.out.println("이번 box의 내용물 = " + Arrays.toString(box)); // todo
        }

        // boxes 리스트의 원소를 하나씩 순회하며, '각 box에서 최하품(box[m - 1] 값) * m'을 answer에 더함
        for (int i = 0; i < boxes.size(); i++) {
            int[] box = boxes.get(i);
            System.out.println("boxes 리스트의 " + (i + 1) + "번째 box 내용물 = " + Arrays.toString(box)); // todo
            answer += box[m - 1] * m;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1})); // 8
        System.out.println(solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2})); // 33
    }
}
