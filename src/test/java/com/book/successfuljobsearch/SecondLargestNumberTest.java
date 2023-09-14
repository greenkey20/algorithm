package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.book.successfuljobsearch.SecondLargestNumber.findSecondLargestNumber;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

// 2023.9.15(금) 0h45
public class SecondLargestNumberTest {

    @Test
    @DisplayName("일반적인 숫자 리스트가 입력된 경우 테스트")
    void testCase1() {
        // given
        List<Integer> numbers = Arrays.asList(19, 20, 99, 22, 33, 100, 101, 1);

        // when
        int actual = findSecondLargestNumber(numbers);

        // then
        assertThat(actual, is(equalTo(100)));
    }
}
