package com.baekjoon.lv2silver.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.7.6(목) 19h55
public class Main2579Test {

    @Test
    void testMain2579Case1() {
        // given
        int n = 6;
        int[] scores = {10, 20, 15, 25, 10, 20};

        // when
        int result = Main2579.solution(n, scores);

        // then
        assertEquals(75, result);
    }

    @Test
    void testMain2579Case2() {
        // given
        int n = 3;
        int[] scores = {10, 20, 15};

        // when
        int result = Main2579.solution(n, scores);

        // then
        assertEquals(35, result);
    }
}
