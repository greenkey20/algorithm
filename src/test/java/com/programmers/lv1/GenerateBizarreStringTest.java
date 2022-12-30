package com.programmers.lv1;

import org.junit.jupiter.api.Test;
import com.programmers.lv1.GenerateBizarreString;

import static org.junit.jupiter.api.Assertions.*;

class GenerateBizarreStringTest {

    @Test
    void testSolution() {
        // given
        String s = "  tRy hello  WORLD    ";
        String expected = "  TrY HeLlO  WoRlD    ";

        // when
        String actual = GenerateBizarreString.solution(s);

        // then
        assertEquals(expected, actual);
    }

}