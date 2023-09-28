package com.book.interviewsexposed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.book.interviewsexposed.ReverseString.reverseString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

// 2023.9.28(목) 21h10
public class ReverseStringTest {

    @Test
    @DisplayName("일반적인 입력이 들어온 경우 테스트1")
    void testCase1() {
        // given
        String s = "abcd e";

        // when
        String actual = reverseString(s);

        // then
        assertThat(actual, is(equalTo("e dcba")));
    }
}
