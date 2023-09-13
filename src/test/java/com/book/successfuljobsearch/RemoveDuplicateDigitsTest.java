package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.book.successfuljobsearch.RemoveDuplicateDigits.removeDuplicateDigits;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

// 2023.9.14(목) 0h20
public class RemoveDuplicateDigitsTest {

    @Test
    @DisplayName("일반적인 숫자 리스트가 입력된 경우 테스트")
    void testCase1() {
        // given
        List<Integer> digits = Arrays.asList(0, 1, 3, 2, 3, 4, 5, 4);

        // when
        Set<Integer> actual = removeDuplicateDigits(digits);

        // then
        // 확인1) 결과 set의 원소의 갯수가 예상 결과와 같은지 확인
        assertThat(actual.size(), is(equalTo(6)));

        // 확인2) 결과 set(Treeset으로써 오름차순으로 정렬되어 있음)과 expected 숫자 목록/집합이 같은지, 원소 하나하나 순서대로 확인
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5);

        Iterator<Integer> iterator = actual.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            int num = iterator.next();
            assertThat(num, is(equalTo(expected.get(idx))));
            idx++;
        }
    }
}
