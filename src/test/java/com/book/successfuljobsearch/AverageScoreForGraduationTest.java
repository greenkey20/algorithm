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
        int expected = 1; // 20h10 책 다시 읽으며 생각해보니, 기존 과목 점수가 없는 경우 = 빈 배열이 입력으로 들어온 경우, 1번 100점 맞으면 평균 90점 이상이 되는 것이므로, 1을 return하는 게 맞음
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

    @Test
    @DisplayName("입력 배열 원소 중 음수가 있는 경우 테스트")
    void testCase4() {
        // given
        int[] scores = new int[]{0, 60, -76, 40};

        // when + then
        assertThrows(IllegalArgumentException.class, () -> getNumOfExamsForGraduation(scores));
    }
}
