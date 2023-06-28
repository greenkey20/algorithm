package com.baekjoon.lv2silver.stack;

import com.baekjoon.lv3gold.stack.Main2504v2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.6.25(일) 6h
class Main2504v2Test {

    @Test
    @DisplayName("ps1 테스트")
    void testMain2504v2Case1() {
        // given
        String ps1 = "(()[[]])([])";
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
}
