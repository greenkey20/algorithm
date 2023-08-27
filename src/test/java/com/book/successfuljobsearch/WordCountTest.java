package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.book.successfuljobsearch.WordCount.countWords;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 2023.8.27(일) 10h30
public class WordCountTest {

    @Test
    @DisplayName("입력으로 null이 들어온 경우 테스트")
    void testCase1() {
        // given
        String[] words = null;

        // when + then
        assertThrows(NullPointerException.class, () -> countWords(words));
    }

    @Test
    @DisplayName("입력으로 빈 배열이 들어온 경우 테스트")
    void testCase2() {
        // given
        String[] words = {};

        // when
        String actual = countWords(words);

        // then
        assertTrue(actual.contains("빈 배열"));
    }

    @Test
    @DisplayName("빈 문자열만 원소로 들어온 경우 테스트")
    void testCase3() {
        // given
        String[] words = {"", "", ""};

        // when
        String actual = countWords(words);

        // then
        assertThat(actual, is(equalTo("")));
    }

    @Test
    @DisplayName("일반 문자열, 빈 문자열이 섞여서 입력으로 들어온 경우 테스트")
    void testCase4() {
        // given
        String[] words = {"과목", "수첩", "", "연필", "과목", "", "시험", "가방", "가방", "가방"};

        // when
        // 나의 생각 = map, set처럼 순서 보장 안 되는 경우 어떻게 내용물을 테스트하는 것이 좋은가?
        String actual = countWords(words);

        // then
        System.out.println(actual);
    }
}
