package com.book.interviewsexposed;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.book.interviewsexposed.FizzBuzz.printFizzBuzz;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;

// 2023.9.23(토) 1h15
public class FizzBuzzTest {

    @Test
    @DisplayName("자연수가 아닌 n이 주어진 경우 테스트")
    void testCase1() {
        // given
        int n = 0;

        // when
        String actual = printFizzBuzz(n);

        // then
        assertNull(actual);
    }

    @Test
    @DisplayName("n = 1로 주어진 경우 테스트") // edge case
    void testCase2() {
        // given
        int n = 1;

        // when
        String actual = printFizzBuzz(n);

        // then
        assertThat(actual, is(equalTo("1 ")));
    }

    @Test
    @DisplayName("n = 7로 주어진 경우 테스트") // 첫번째 edge case 3과 5 + 두번째 3의 배수인 6을 테스트
    void testCase3() {
        // given
        int n = 7;

        // when
        String actual = printFizzBuzz(n);

        // then
        assertThat(actual, is(equalTo("1 2 Fizz 4 Buzz Fizz 7 ")));
    }

    @Test
    @DisplayName("n = 16으로 주어진 경우 테스트")
        // edge case 15 테스트
    void testCase4() {
        // given
        int n = 16;

        // when
        String actual = printFizzBuzz(n);

        // then
        assertThat(actual, is(equalTo("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 ")));
    }
}
