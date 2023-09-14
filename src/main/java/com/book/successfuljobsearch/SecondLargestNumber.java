package com.book.successfuljobsearch;

// 2023.9.15(금) 0h40

import java.util.Collections;
import java.util.List;

/**
 * 목록에서 두번째로 가장 큰 숫자를 찾아 리턴하는 코드를 작성하라
 */
public class SecondLargestNumber {
    public static int findSecondLargestNumber(List<Integer> numbers) {
        int secondLargestNum = 0;

        // 방법1) 정렬 알고리즘 구현

        // 방법2) 내장 함수 활용
        // 0h50 나의 생각 = numbers에 같은 숫자가 2번 이상 있을 수도 있는 바, 아래와 같이 판단할 수는 없음
        Collections.sort(numbers);
        secondLargestNum = numbers.get(numbers.size() - 2);

        return secondLargestNum;
    }

}
