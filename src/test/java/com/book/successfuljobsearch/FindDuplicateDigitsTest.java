package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.book.successfuljobsearch.FindDuplicateDigits.findDuplicateDigits;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 2023.9.13(수) 23h50
public class FindDuplicateDigitsTest {

    @Test
    @DisplayName("일반적인 숫자 리스트가 입력된 경우 테스트")
    void testCase1() {
        // given
        List<Integer> digits = Arrays.asList(0, 1, 3, 2, 3, 4, 5, 4);

        // when
        Set<Integer> expected = findDuplicateDigits(digits);

        // then
        assertThat(expected.size(), is(equalTo(2)));
        assertTrue(expected.contains(3) && expected.contains(4));
    }
}
