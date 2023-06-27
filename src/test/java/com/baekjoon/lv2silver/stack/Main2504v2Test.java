package com.baekjoon.lv2silver.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.6.25(일) 6h
class Main2504v2Test {

    @Test
    void testMain2504v2() {
        // given
        String ps1 = "(()[[]])([])";
        String ps2 = "[][]((])";

        // when
        System.out.println("===== ps1 = " + ps1 + " =====");
        int result1 = Main2504v2.solution(ps1);
        System.out.println("===== ps2 = " + ps2 + " =====");
        int result2 = Main2504v2.solution(ps2);

        // then
        assertEquals(28, result1);
        assertEquals(0, result2);
    }
}
