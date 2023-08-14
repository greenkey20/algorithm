package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.book.successfuljobsearch.AverageScoreForGraduation.getNumOfExamsForGraduation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

// 2023.8.14(월) 13h
class AverageScoreForGraduationTest {

    @Test
    @DisplayName("입력으로 null이 들어온 경우 테스트")
    void testCase1() {
        // given
        int[] scores = null;

        // when
//        getNumOfExamsForGraduation(scores);

        // when + then
        assertThrows(NullPointerException.class, () -> getNumOfExamsForGraduation(scores));
    }

    @Test
    @DisplayName("입력으로 빈 배열이 들어온 경우 테스트")
    void testCase2() {
        // given
        int[] scores = new int[]{};

        // when
        int actual = getNumOfExamsForGraduation(scores);

        // then
        int expected = 0;
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    @DisplayName("edge case")
    void testCase3() {
        // given
        int[] scores = new int[]{80};

        // when
        int actual = getNumOfExamsForGraduation(scores);

        // then
        int expected = 1;
        assertThat(actual, is(equalTo(expected)));
    }
}
