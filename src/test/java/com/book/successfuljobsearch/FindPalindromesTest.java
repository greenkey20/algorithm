package com.book.successfuljobsearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.book.successfuljobsearch.FindPalindromes.findPalindromes;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

// 2023.8.29(화) 18h5
public class FindPalindromesTest {

    @Test
    @DisplayName("n 또는 m이 음수로 주어진 경우 테스트")
    void testCase1() {
        // given
        int n = 100;
        int m = -4;

        // when + then
        assertThrows(RuntimeException.class, () -> findPalindromes(n, m));
    }

    @Test
    @DisplayName("n과 m이 음수로 주어진 경우 테스트")
    void testCase2() {
        // given
        int n = -3;
        int m = -4;

        // when + then
        assertThrows(RuntimeException.class, () -> findPalindromes(n, m));
    }

    @Test
    @DisplayName("n == m인 경우 테스트")
    void testCase3() {
        // given
        int n = 14;
        int m = 14;

        // when
        String actual = findPalindromes(n, m);

        // then
        String expected = "";
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    @DisplayName("n 또는 m이 1자리 수인 경우 테스트")
    void testCase4() {
        // given
        int n = 111;
        int m = 0;

        // when
        String actual = findPalindromes(n, m);

        // then
//        System.out.println("testCase4의 actual = " + actual);

        String expected = "0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, ";
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    @DisplayName("입/출력 예시 테스트")
    void testCase5() {
        // given
        int n = 10;
        int m = 30;

        // when
        String actual = findPalindromes(n, m);

        // then
        String expected = "11, 22, ";
        assertThat(actual, is(equalTo(expected)));
    }

}
