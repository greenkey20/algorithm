package com.book.successfuljobsearch;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// 2023.9.14(목) 0h10

/**
 * 목록에서 중복된 숫자를 제거한 목록을 리턴하는 코드를 작성하라
 */
public class RemoveDuplicateDigits {
    public static Set<Integer> removeDuplicateDigits(List<Integer> digits) {
        Set<Integer> result = new TreeSet<>();

        for (int digit : digits) {
            result.add(digit);
        }

        return result;
    }
}
