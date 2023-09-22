package com.book.successfuljobsearch;

// 2023.9.16(토) 1h5

import java.util.Collections;
import java.util.List;

/**
 * 주어진 목록에서 나열할 수 있는 개수를 구하시오
 * e.g. 입력 값 = {10, 4, 20, 1, 3, 2, 5} -> 결과 값 = 5
 */
public class NumbersInRow {

    public static int countNumbersInRow(List<Integer> numbers) {
        int result = 0;

        // 입력으로 주어진 숫자 리스트를 오름차순으로 정렬
        Collections.sort(numbers);

        for (int i = 1; i < numbers.size(); i++) {
            int thisNum = numbers.get(i);
            int prevNum = numbers.get(i - 1);

            if (thisNum == prevNum + 1) {
                result++;
            }
        }

        return result;
    }
}
