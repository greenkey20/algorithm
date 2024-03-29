package com.baekjoon.lv2silver.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.6.25(일) 6h
class Main2504v2Test {

    @Test
    @DisplayName("ps1 테스트")
    void testMain2504v2Case1() {
        // given
//        String ps1 = "(()[[]])[([])]"; // 22 + 3*2*3 = 40
        String ps1 = "(()[[]])([])"; // 22 + 3*2 = 28
//        String ps2 = ")(";

        // when
//        System.out.println("===== ps1 = " + ps1 + " =====");
        int result1 = Main2504v2.solution(ps1);
//        System.out.println("===== ps2 = " + ps2 + " =====");
//        int result2 = Main2504v2.solution(ps2);

        // then
        assertEquals(28, result1);
//        assertEquals(0, result2);
    }

    @Test
    @DisplayName("ps2 테스트")
    void testMain2504v2Case2() {
        // given
        String ps2 = "[][]((])";

        // when
        int result2 = Main2504v2.solution(ps2);

        // then
        assertEquals(0, result2);
    }

    // 2023.6.28(수) 23h50 추가
    @Test
    @DisplayName("ps3 테스트")
    void testMain2504v2Case3() {
        // given
        String ps3 = ")"; // 이러한 경계값 케이스 테스트 해 보니 stack.peek() 부분에서 empty stack 오류 발생 확인

        // when
        int result3 = Main2504v2.solution(ps3);

        // then
        assertEquals(0, result3);
    }

    // 2023.6.29(목) 0h5 나의 질문 = 왜 이 테스트만 별도로 실행 시에만 empty stack 예외가 발생하고, 이 테스트 클래스 전체 테스트할 때는 통과하는 거지?
    @Test
    @DisplayName("ps4 테스트")
    void testMain2504v2Case4() {
        // given
        String ps4 = ")(";

        // when
        int result4 = Main2504v2.solution(ps4);

        // then
        assertEquals(0, result4);
    }

    // 2023.6.29(목) 0h20 추가
    @Test
    @DisplayName("ps5 테스트")
    void testMain2504v2Case5() {
        // given
        String ps5 = "()]";

        // when
        int result = Main2504v2.solution(ps5);

        // then
        assertEquals(0, result);
    }

    // 2023.6.29(목) 0h25 추가 = 현재 actual 9가 나옴 -> 2023.6.29(목) 0h45 버전으로 고침
    @Test
    @DisplayName("ps6 테스트")
    void testMain2504v2Case6() {
        // given
        String ps6 = "()[]";

        // when
        int result = Main2504v2.solution(ps6);

        // then
        assertEquals(5, result);
    }

    // 기본 케이스
    @Test
    @DisplayName("ps7 테스트")
    void testMain2504v2Case7() {
        // given
        String ps7 = "()";

        // when
        int result = Main2504v2.solution(ps7);

        // then
        assertEquals(2, result);
    }

    // 기본 케이스
    @Test
    @DisplayName("ps8 테스트")
    void testMain2504v2Case8() {
        // given
        String ps8 = "[]";

        // when
        int result = Main2504v2.solution(ps8);

        // then
        assertEquals(3, result);
    }

    // 2023.6.29(목) 0h50 추가
    @Test
    @DisplayName("ps9 테스트")
    void testMain2504v2Case9() {
        // given
        String ps9 = "([])";

        // when
        int result = Main2504v2.solution(ps9);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("ps10 테스트")
    void testMain2504v2Case10() {
        // given
        String ps10 = "[([)]";

        // when
        int result = Main2504v2.solution(ps10);

        // then
        assertEquals(0, result);
    }
}
