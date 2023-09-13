package com.book.successfuljobsearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 2023.9.13(수) 23h40

/**
 * 목록에 중복된 숫자를 찾아 출력하는 코드를 작성하라
 */
public class FindDuplicateDigits {
    public static Set<Integer> findDuplicateDigits(List<Integer> digits) {
        // digits의 원소를 하나하나 순회하며, set에 담아본다
        Set<Integer> setOfDuplicateDigits = new HashSet<>();
        Set<Integer> setOfNotDuplicateDigits = new HashSet<>();

        for (int digit : digits) {
            if (setOfNotDuplicateDigits.contains(digit)) {
                setOfDuplicateDigits.add(digit);
            } else {
                setOfNotDuplicateDigits.add(digit);
            }
        }

        return setOfDuplicateDigits;
    }
}
