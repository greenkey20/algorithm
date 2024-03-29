package com.book.successfuljobsearch;

import java.util.HashSet;
import java.util.Set;

// 2023.8.28(월) 14h10
public class ShuffleCards {
    public static void main(String[] args) {

    }

    /**
     * 1~10 숫자가 적힌 카드가 있다.
     * 프로그램 실행할 때마다 다른 숫자 카드 배열을 제공하는 프로그램을 만들어라.
     * (중복되지 않은 10개의 결과 값이 나열되어야 하며, 결과는 매번 상이해야 함)
     *
     * 2023.8.28(월) 15h15 문제 조건 변경
     * 정수 n을 매개변수로 입력 받아 무작위로 나열하는 프로그램을 작성하라.
     *
     * 2023.8.29(화) 15h20 나의 생각 = 예외 처리를 고민해봐
     * 1. n이 음수로 주어진 경우
     * 2. n이 0 또는 1로 주어진 경우
     *
     * @return
     */
    public static int[] shuffleCards(int n) {
        // 2023.8.29(화) 15h20 추가
        try {
            if (n < 2) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal argument exception이 발생했습니다. 유효하지 않은 n이 입력되었습니다.");
        }

        // 10 shuffled cards를 담아서 반환할, 크기 10인 정수형 배열 선언 및 초기화
        int[] resultsArray = new int[n];

        // 특정 숫자가 이미 뽑혔는지 확인하기 위해 set을 만들어 활용하고자 함
        Set<Integer> resultsSet = new HashSet<>();

        // 10번 random 숫자를 뽑고자 함
        for (int i = 0; i < n; i++) {
            // 1~10 사이의 정수를 랜덤으로 뽑음
            int thisNum = ((int) (Math.random() * n)) + 1;

            if (resultsSet.contains(thisNum)) { // 금번 뽑은 숫자가 이미 뽑힌 숫자라면
                i--; // i를 증가시키지 말고, 다시 뽑아야 함
//                continue;
            } else { // 금번 뽑은 숫자가 아직 뽑힌 숫자가 아니라면
                resultsSet.add(thisNum); // 이 숫자를 set에 넣음
                resultsArray[i] = thisNum; // 이 숫자를 반환할 배열 i번째 원소로 세팅
            }
        }

        // 위 반복문에 의해 1~10의 숫자가 랜덤으로 담긴 배열을 반환하며 메서드 종료
        return resultsArray;
    }
}
