package com.book.successfuljobsearch;

import java.util.List;

// 2023.9.15(금) 0h30

/**
 * 목록에서 가장 큰 숫자를 찾아 리턴하는 코드를 작성하라
 */
public class LargestNumber {
    public static int findLargestNumber(List<Integer> numbers) {
        int largestNumber = 0;

        for (int number : numbers) {
            if (number > largestNumber) {
                largestNumber = number;
            }
        }

        return largestNumber;
    }
}
