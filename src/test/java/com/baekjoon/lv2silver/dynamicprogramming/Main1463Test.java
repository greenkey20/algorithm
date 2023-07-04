package com.baekjoon.lv2silver.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.7.5(수) 0h25
public class Main1463Test {

    @Test
    void testMain1453Case1() {
        // given
        int n = 1;

        // when
        int result = Main1463.solution(n);

        // then
        assertEquals(0, result);
    }

    @Test
    void testMain1453Case2() {
        // given
        int n = 2;

        // when
        int result = Main1463.solution(n);

        // then
        assertEquals(1, result);
    }

    @Test
    void testMain1453Case3() {
        // given
        int n = 10;

        // when
        int result = Main1463.solution(n);

        // then
        assertEquals(3, result);
    }
}
