package 프로그래머스.lv1.q12906;

import java.util.*;

class Solution {
    // 2022.11.5(토) 23h45
    public int[] solution(int[] arr) {        
        // 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 함 -> queue 자료구조 사용
        // 인자/입력으로 받은 arr의 원소들을 0번 인덱스부터 차례로 queue에 담음
        Queue q = new LinkedList();
        for (int i : arr) {
            q.offer(i);
        }
        
        List<Integer> answerList = new ArrayList<>(); // 반환할 수의 나열을 일단 list로 만들고자 함
        
        // queue에서 원소를 하나하나 꺼내어서
        while (!q.isEmpty()) {
            Integer pollNum = (Integer) q.poll(); // 현재 queue에서 꺼낸 수를 pollNum 변수에 담음
            
            // 해당 원소가 현재 list에 없는 경우, list에 추가 -> 1차 제출해보니, 내가 문제를 잘못 이해했음을 알게 됨
            /*
            if (!answerList.contains(pollNum)) {
                answerList.add(pollNum);
            }
            */
            if (!answerList.isEmpty()) { // answerList가 비어있지 않다면
                if (pollNum != answerList.get(answerList.size() - 1)) { // 그리고 answerList의 마지막 요소의 값이 지금 queue에서 꺼낸 수와 같지 않다면
                    // 그 수를 answerList에 추가함
                    answerList.add(pollNum);
                }
            } else { // answerList가 비어있다면 = queue에서 처음 꺼내는 수는 무조건 answerList에 담아야 함
                answerList.add(pollNum);
            }            
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }        

        return answer;
    }

    /* 회고
    1. 배열 arr의 각 원소는 0~9 정수라는 점을 이용해서, 반복 여부 비교할 변수를 하나 10이나 -1 등의 숫자로 만들어두고 시작할 수 있음
    2. 어떤 분은 리턴할 자료를 stack으로 만듦 + stack.peek() 함수 이용(https://school.programmers.co.kr/questions/37904)
     */
}